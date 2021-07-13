package com.kainos.ea.CompetencyFiles;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/api")
public class CompetencyResource {

    private final CompetencyDAO competencyDAO;

    public CompetencyResource(CompetencyDAO competencyDAO) {
        this.competencyDAO = competencyDAO;
    }

    @GET
    @Path("/band/getCompetencies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Competency> getCompetencies() { return competencyDAO.getCompetencies(); }

    @GET
    @Path("/band/{bandID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Competency getCompetencyByID(@PathParam("compID") int compID) { return competencyDAO.getCompetencies().get(compID);}
}
