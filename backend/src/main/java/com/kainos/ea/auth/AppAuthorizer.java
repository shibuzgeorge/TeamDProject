package com.kainos.ea.auth;

import com.kainos.ea.user.User;
import io.dropwizard.auth.Authorizer;

public class AppAuthorizer implements Authorizer<User>
{
    @Override
    public boolean authorize(User user, String role) {
        return user.getRole() != null && user.getRole().contains(role);
    }
}
