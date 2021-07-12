package com.kainos.ea.responsibility;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class ResponsibilityResource {

    private final ResponsibilityDAO responsibilityDAO;

    public ResponsibilityResource(ResponsibilityDAO responsibilityDAO) {
        this.responsibilityDAO = responsibilityDAO;
    }

    @GET
    @Path("/role/getRoles/{roleID}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getResponsibility() {
//        return ResponsibilityDAO.getResponsibility();
        return "";
        //TODO: sort out this method error
    }
}
