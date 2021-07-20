package com.kainos.ea.user;

import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class UserResource {


    private final UserDAO userDAO;

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GET
    @RolesAllowed({ "Admin" })
    @Path("/user/getUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userDAO.getUsers();
    }


    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@Auth User user) throws Exception {

    return userDAO.getUser(user.getUsername());
    }

}
