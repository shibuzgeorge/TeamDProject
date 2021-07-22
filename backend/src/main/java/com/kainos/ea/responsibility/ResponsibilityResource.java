package com.kainos.ea.responsibility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api(value="/responsibility")
@Path("/api")
public class ResponsibilityResource {

    private final ResponsibilityDAO responsibilityDAO;

    public ResponsibilityResource(ResponsibilityDAO responsibilityDAO) {
        this.responsibilityDAO = responsibilityDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/responsibility/getResponsibilityByID/{roleID}")
    @ApiOperation(
            value = "Gets a specific responsibility",
            notes = "Returns the responsibility based on the role ID received",
            response = Responsibility.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @Produces(MediaType.APPLICATION_JSON)
    public Responsibility getResponsibility(@PathParam ("roleID") @NotNull @Valid int roleID) {
        return responsibilityDAO.getResponsibility(roleID);
    }
}
