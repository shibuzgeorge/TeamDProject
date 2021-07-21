package com.kainos.ea.user;

import io.dropwizard.auth.Auth;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
    @ApiOperation(
            value = "Gets all users on record",
            notes = "Returns the users stored in the database",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid URL, double check your parameters match the API documentation in the README"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 503, message = "This service is not currently available"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 404, message = "No users found!") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userDAO.getUsers();
    }


    @POST
    @Path("/login")
    @ApiOperation(
            value = "Posts the username and password",
            notes = "In the body is the input from the user in the login screen",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Login details were successfully received by the API"),
            @ApiResponse(code = 400, message = "This is an invalid request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 503, message = "This service is not currently available"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 404, message = "No training found in that Band") })
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@Auth User user) throws Exception {

    return userDAO.getUser(user.getUsername());
    }

}
