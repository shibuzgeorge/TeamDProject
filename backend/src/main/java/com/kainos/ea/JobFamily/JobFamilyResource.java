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
    @Path("/jobFamily/getJobFamily/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public JobFamily getJobFamilyByID(@PathParam("id") int id) {
        return jobFamilyDAO.getJobFamilyByID(id);
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
        if(jobFamilyDAO.checkIfJobFamilyNameAndCapabilityComboExist(jobFamilyName, capability) != null){
            return false;
        }else{
        return jobFamilyDAO.insertNewJobFamily(jobFamilyName, capability);
        }
    }

    @PUT
    @RolesAllowed({ "Admin" })
    @Timed
    @Path("/editJobFamily/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean editJobFamily(@FormParam("jobFamilyName")String jobFamilyName, @FormParam("capability") String capability,
                                 @PathParam("id") int id){
        if(jobFamilyDAO.checkIfJobFamilyNameAndCapabilityComboExist(jobFamilyName, capability) != null){
            return false;
        }else{
            return jobFamilyDAO.editJobFamilyName(jobFamilyName, id) && jobFamilyDAO.editJobFamilyCapability(capability, id);
        }
    }
}
