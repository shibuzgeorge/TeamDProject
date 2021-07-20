package com.kainos.ea.responsibility;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class ResponsibilityResource {

    private final ResponsibilityDAO responsibilityDAO;

    public ResponsibilityResource(ResponsibilityDAO responsibilityDAO) {
        this.responsibilityDAO = responsibilityDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/responsibility/getResponsibilityByID/{roleID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Responsibility getResponsibility(@PathParam ("roleID") @NotNull @Valid int roleID) {
        return responsibilityDAO.getResponsibility(roleID);
    }
}
