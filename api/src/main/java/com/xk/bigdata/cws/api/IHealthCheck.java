package com.xk.bigdata.cws.api;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.HttpRetryException;
import java.util.Map;

@Path("/system")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IHealthCheck {

    @Path("/health")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    Map<String, Object> healthCheck();
}
