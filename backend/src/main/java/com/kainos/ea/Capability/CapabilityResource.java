package com.kainos.ea.Capability;

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

@Api(value="/capability")
@Path("/api")
public class CapabilityResource {

    private final CapabilityDAO capabilityDAO;

    public CapabilityResource(CapabilityDAO capabilityDAO) {
        this.capabilityDAO = capabilityDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/capability/getCapability")
    @ApiOperation(
            value = "Get a specific capability",
            notes = "Returns a list of all the capabilities",
            response = Capability.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid URL, double check your parameters match the API documentation in the README"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 503, message = "This service is not currently available"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 404, message = "Capability list not found") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Capability> getCapability() {
        return capabilityDAO.getCapability();
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/capability/{capability}")
    @ApiOperation(
            value = "Get a specific capability",
            notes = "Return a specific capability based on the URL",
            response = Capability.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid URL, double check your parameters match the API documentation in the README"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 503, message = "This service is not currently available"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 404, message = "No capability with that ID") })
    @Produces(MediaType.APPLICATION_JSON)
    public Capability getCapabilityByName(@PathParam("capability") String capability) {
        return capabilityDAO.getCapabilityByName(capability);
    }
}
