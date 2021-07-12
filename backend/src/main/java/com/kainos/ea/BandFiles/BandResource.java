package com.kainos.ea.BandFiles;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class BandResource {

    private final BandDAO bandDAO;

    public BandResource(BandDAO cityDAO) {
        this.bandDAO = cityDAO;
    }

    @GET
    @Path("/band/getBands")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Band> getBands() {
        return bandDAO.getBands();
    }
}
