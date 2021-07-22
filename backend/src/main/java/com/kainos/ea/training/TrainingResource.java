package com.kainos.ea.training;

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

@Api(value="/training")
@Path("/api")
public class TrainingResource {

    private final TrainingDAO trainingDAO;

    public TrainingResource(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/training/getTrainings")
    @ApiOperation(
            value = "Gets all training records",
            notes = "Returns a list of all the different trainings in the database",
            response = Training.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> getTrainings() {
        return trainingDAO.getTrainings();
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/training/getTrainingByBand/{bandID}")
    @ApiOperation(
            value = "Gets a specific training record",
            notes = "Returns the training record using the Band ID received",
            response = Training.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> getTrainingByBandID(@PathParam("bandID") int bandID) {
        return trainingDAO.getTrainingByBandID(bandID);
    }
}
