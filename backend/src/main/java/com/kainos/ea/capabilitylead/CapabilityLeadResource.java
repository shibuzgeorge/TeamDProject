package com.kainos.ea.capabilitylead;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class CapabilityLeadResource {

    private final CapabilityLeadDAO capabilityLeadDAO;

    public CapabilityLeadResource(CapabilityLeadDAO capabilityLeadDAO) {
        this.capabilityLeadDAO = capabilityLeadDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/capability/getCapabilityLeads")
    @ApiOperation(
            value = "Gets all capability leads",
            notes = "Returns a list of all the capability leads",
            response = CapabilityLead.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid URL, double check your parameters match the API documentation in the README"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 503, message = "This service is not currently available"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 404, message = "No capability leader with that ID") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<CapabilityLead> getCapabilityLeads() {
        return capabilityLeadDAO.getCapabilityLead();
    }
}
