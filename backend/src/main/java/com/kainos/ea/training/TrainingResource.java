package com.kainos.ea.training;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class TrainingResource {

    private final TrainingDAO trainingDAO;

    public TrainingResource(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/training/getTrainings")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> getTrainings() {
        return trainingDAO.getTrainings();
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/training/getTrainingByBand/{bandID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Training> getTrainingByBandID(@PathParam("bandID") int bandID) {
        return trainingDAO.getTrainingByBandID(bandID);
    }
}
