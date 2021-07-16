package com.kainos.ea.Capability;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class CapabilityResource {

    private final CapabilityDAO capabilityDAO;

    public CapabilityResource(CapabilityDAO capabilityDAO) {
        this.capabilityDAO = capabilityDAO;
    }

    @GET
    @Path("/capability/getCapability")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Capability> getCapability() {
        return capabilityDAO.getCapability();
    }
}
