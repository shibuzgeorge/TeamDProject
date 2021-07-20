package com.kainos;

import com.kainos.ea.user.User;
import com.kainos.ea.user.UserDAO;
import com.kainos.ea.user.UserResource;
import io.dropwizard.auth.UnauthorizedHandler;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(DropwizardExtensionsSupport.class)
public class UserResourceTest {

    private static final UserDAO DAO = mock(UserDAO.class);
    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new UserResource(DAO))
            .build();
    private User user;

    @BeforeEach
    void setup() {
        user = new User();
        user.setUserID(1);
        user.setUsername("Test user");
        user.setRole("Employee");
    }

    @AfterEach
    void tearDown() {
        reset(DAO);
    }


    @Test
    void loginSuccess() {
        final User newUser = new User("Test user 1", "Employee");
        newUser.setUserID(1);

        when(DAO.getUser("Test user 1")).thenReturn(newUser);
        final Response response = EXT.target("/api/login")
                .request().post(Entity.entity(newUser, MediaType.APPLICATION_JSON_TYPE));

        verify(DAO).getUser("Test user 1");
        Assertions.assertEquals(response.getStatusInfo(), Response.Status.OK);
    }

    @Test
    void loginFailure() {
        final User newUser = new User("Test user 2", "Random");
        when(DAO.getUser("Test user 2")).thenThrow(NotAuthorizedException.class);
        final Response response = EXT.target("/api/login")
                .request().post(Entity.entity(newUser, MediaType.APPLICATION_JSON_TYPE));

        Assertions.assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
    }
}
