package com.kainos.ea.auth;

import com.kainos.ea.user.User;
import com.kainos.ea.user.UserDAO;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.PrincipalImpl;
import io.dropwizard.auth.basic.BasicCredentials;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

/**
 * Validates credentials for basic auth on login
 *
 * @author Shibu George
 */
public class BasicAuthenticator implements Authenticator<BasicCredentials, User> {

    private final UserDAO userDAO;

    public BasicAuthenticator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if (isValidCredentials(credentials)) {
            return Optional.of(new User(credentials.getUsername(), userDAO.getRole(credentials.getUsername())));
        }
        return Optional.empty();
    }

    private boolean isValidCredentials(BasicCredentials credentials) {
        User user = userDAO.getUser(credentials.getUsername());

        if (user == null){
            return false;
        } else {
            return BCrypt.checkpw(credentials.getPassword(), userDAO.getHashedPassword(credentials.getUsername()));
        }
    }
}
