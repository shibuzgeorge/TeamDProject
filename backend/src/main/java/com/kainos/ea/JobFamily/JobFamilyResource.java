package com.kainos.ea.JobFamily;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class JobFamilyResource {

    private final JobFamilyDAO jobFamilyDAO;

    public JobFamilyResource(JobFamilyDAO jobFamilyDAO) {
        this.jobFamilyDAO = jobFamilyDAO;
    }

    @GET
    @Path("/jobFamily/getJobFamily")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobFamily> getJobFamilies() {
        return jobFamilyDAO.getJobFamilies();
    }

    @GET
    @Path("/jobFamilyFromCapability/{capability}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobFamily> getJobFamilyByCapability(@PathParam("capability") String capability) {
        return jobFamilyDAO.getJobFamilyByCapability(capability);
    }

    @POST
    @Timed
    @Path("/newJobFamily")
    @Consumes(MediaType.APPLICATION_JSON)
    public int insertJobFamily(){
        return 0;
    }
}
