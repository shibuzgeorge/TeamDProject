package com.kainos.ea.JobFamily;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="/jobFamily")
@Path("/api")
public class JobFamilyResource {

    private final JobFamilyDAO jobFamilyDAO;

    public JobFamilyResource(JobFamilyDAO jobFamilyDAO) {
        this.jobFamilyDAO = jobFamilyDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/jobFamily/getJobFamily")
    @ApiOperation(
            value = "Gets all job families",
            notes = "Returns a list of all job families in the database",
            response = JobFamily.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 404, message = "Job family list not found") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobFamily> getJobFamilies() {
        return jobFamilyDAO.getJobFamilies();
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/jobFamily/getJobFamily/{id}")
    @ApiOperation(
            value = "Gets a specific job family",
            notes = "Returns the job family record with the matching ID",
            response = JobFamily.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @Produces(MediaType.APPLICATION_JSON)
    public JobFamily getJobFamilyByID(@PathParam("id") int id) {
        return jobFamilyDAO.getJobFamilyByID(id);
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/jobFamilyFromCapability/{capability}")
    @ApiOperation(
            value = "Gets a job family using an input capability",
            notes = "Returns a single job family record with the matching capability",
            response = JobFamily.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error") })
    @Produces(MediaType.APPLICATION_JSON)
    public List<JobFamily> getJobFamilyByCapability(@PathParam("capability") String capability) {
        return jobFamilyDAO.getJobFamilyByCapability(capability);
    }

    @POST
    @RolesAllowed({ "Admin" })
    @Timed
    @Path("/newJobFamily")
    @ApiOperation(
            value = "Posts a new job family",
            notes = "This is used to create a new job family in the system",
            response = JobFamily.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error")})
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
    @ApiOperation(
            value = "PUT job family using an input ID",
            notes = "Replaces the job family name, capability of the job family record with the matching ID",
            response = JobFamily.class)
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 500, message = "Internal server error") })
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
