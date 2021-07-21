package com.kainos.ea.RoleFiles;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value="/role")
@Path("/api")
public class RoleResource {

    private final RoleDAO roleDAO;

    public RoleResource(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/role/getRoles")
    @ApiOperation(
            value = "Gets all roles",
            notes = "Returns a list of all roles in the database",
            response = Role.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid URL, double check your parameters match the API documentation in the README"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 503, message = "This service is not currently available"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 404, message = "Role list not found") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRoles() {
        return roleDAO.getRoles();
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/role/{roleID}")
    @ApiOperation(
            value = "Gets a specific role",
            notes = "Returns the role based on the Role ID received",
            response = Role.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid URL, double check your parameters match the API documentation in the README"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 503, message = "This service is not currently available"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 404, message = "No role with that ID exists") })
    @Produces(MediaType.APPLICATION_JSON)
    public Role getRoleByID(@PathParam("roleID") int roleID) {
        return roleDAO.getRoleByID(roleID);
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/roleFromCapability/{capability}")
    @ApiOperation(
            value = "Gets a specific role",
            notes = "Returns the role based on the capability received",
            response = Role.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 503, message = "This service is not currently available"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 404, message = "There are no roles in that capability") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRoleByCapability(@PathParam("capability") String capability) {
        return roleDAO.getRoleByCapability(capability);
    }
}
