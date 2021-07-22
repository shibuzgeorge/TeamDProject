package com.kainos.ea.BandFiles;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/api")
@Api(value="/band")
@Produces({"application/json"})
public class BandResource {

    private final BandDAO bandDAO;

    public BandResource(BandDAO cityDAO) {
        this.bandDAO = cityDAO;
    }

    @GET
    @RolesAllowed({ "Admin", "Employee" })
    @Path("/band/getBands")
    @ApiOperation(
            value = "Gets all bands",
            notes = "Returns a list of bands",
            response = Band.class)
    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Forbidden: This user does not have authorisation for this request"),
            @ApiResponse(code = 401, message = "User is not authorised for this request"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Band> getBands() {
        return bandDAO.getBands();
    }
}
