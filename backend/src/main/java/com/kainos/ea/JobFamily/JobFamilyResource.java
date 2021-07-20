package com.kainos.ea.JobFamily;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class JobFamilyResource {

    private final JobFamilyDAO jobFamilyDAO;

    public JobFamilyResource(JobFamilyDAO jobFamilyDAO) {
        this.jobFamilyDAO = jobFamilyDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/jobFamily/getJobFamily")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobFamily> getJobFamilies() {
        return jobFamilyDAO.getJobFamilies();
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/jobFamilyFromCapability/{capability}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobFamily> getJobFamilyByCapability(@PathParam("capability") String capability) {
        return jobFamilyDAO.getJobFamilyByCapability(capability);
    }
}
