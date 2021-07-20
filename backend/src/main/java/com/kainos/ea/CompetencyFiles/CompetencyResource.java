package com.kainos.ea.CompetencyFiles;

import javax.annotation.security.RolesAllowed;
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
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/competency/getCompetencies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Competency> getCompetencies() { return competencyDAO.getCompetencies(); }

    @GET
    @Path("/competency/{competencyID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Competency getCompetencyByID(@PathParam("competencyID") int compID) { return competencyDAO.getCompetencyByID(compID);}

    @GET
    @Path("/competency/getCompetencyByBand/{bandID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Competency> getCompetencyByBandID(@PathParam("bandID") int bandID) { return competencyDAO.getCompetencyByBandID(bandID);}

}
