package com.kainos.ea.JobFamily;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import com.codahale.metrics.annotation.Timed;

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

    @POST
    @RolesAllowed({ "Admin" })
    @Timed
    @Path("/newJobFamily")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean insertJobFamily(@FormParam("jobFamilyName")String jobFamilyName, @FormParam("capability")String capability){
        return jobFamilyDAO.insertNewJobFamily(jobFamilyName, capability);
    }
}
