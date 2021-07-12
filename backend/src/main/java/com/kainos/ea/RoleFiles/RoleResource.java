package com.kainos.ea.RoleFiles;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class RoleResource {

    private final RoleDAO roleDAO;

    public RoleResource(RoleDAO cityDAO) {
        this.roleDAO = cityDAO;
    }

    @GET
    @Path("/role/getRoles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRoles() {
        return roleDAO.getRoles();
    }

//    @GET
//    @Path("/role/getRoles/{roleID}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getResponsibility() {
//        return roleDAO.getRoles();
//    }
}