package com.kainos.ea;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class JobResource {

    private final JobDAO jobDAO;

    public JobResource(JobDAO cityDAO) {
        this.jobDAO = cityDAO;
    }

    @GET
    @Path("/job/getJobs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Job> getJobs() {
        return jobDAO.getJobs();
    }
}
