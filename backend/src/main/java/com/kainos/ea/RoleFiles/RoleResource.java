package com.kainos.ea.RoleFiles;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class RoleResource {

    private final RoleDAO roleDAO;

    public RoleResource(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @GET
    @Path("/role/getRoles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRoles() {
        return roleDAO.getRoles();
    }

    @GET
    @Path("/role/{roleID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Role getRoleByID(@PathParam("roleID") int roleID) {
        return roleDAO.getRoleByID(roleID);
    }

    @GET
    @Path("/roleFromCapability/{capability}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRoleByCapability(@PathParam("capability") String capability) {
        return roleDAO.getRoleByCapability(capability);
    }
}
