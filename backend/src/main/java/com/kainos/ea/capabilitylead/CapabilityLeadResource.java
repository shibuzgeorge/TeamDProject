package com.kainos.ea.capabilitylead;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class CapabilityLeadResource {

    private final CapabilityLeadDAO capabilityLeadDAO;

    public CapabilityLeadResource(CapabilityLeadDAO capabilityLeadDAO) {
        this.capabilityLeadDAO = capabilityLeadDAO;
    }

    @GET
    @Path("/capability/getCapabilityLeads")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CapabilityLead> getCapabilityLeads() {
        return capabilityLeadDAO.getCapabilityLead();
    }
}
