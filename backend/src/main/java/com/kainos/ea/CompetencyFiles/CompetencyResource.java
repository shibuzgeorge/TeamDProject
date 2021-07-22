package com.kainos.ea.CompetencyFiles;

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

@Api(value="/competency")
@Path("/api")
public class CompetencyResource {

    private final CompetencyDAO competencyDAO;

    public CompetencyResource(CompetencyDAO competencyDAO) {
        this.competencyDAO = competencyDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/competency/getCompetencies")
    @ApiOperation(
            value = "Gets all competencies",
            notes = "Returns a list of all the competencies in the database",
            response = Competency.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Competency> getCompetencies() { return competencyDAO.getCompetencies(); }

    @GET
    @Path("/competency/{competencyID}")
    @ApiOperation(
            value = "Gets all competencies",
            notes = "Returns a list of all the competencies in the database",
            response = Competency.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @Produces(MediaType.APPLICATION_JSON)
    public Competency getCompetencyByID(@PathParam("competencyID") int compID) { return competencyDAO.getCompetencyByID(compID);}

    @GET
    @Path("/competency/getCompetencyByBand/{bandID}")
    @ApiOperation(
            value = "Gets a specific competency",
            notes = "Returns a competency based on the BandID input",
            response = Competency.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Competency> getCompetencyByBandID(@PathParam("bandID") int bandID) { return competencyDAO.getCompetencyByBandID(bandID);}

}
