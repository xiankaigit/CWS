package com.xk.bigdata.cws;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.HttpRetryException;
import java.util.Map;

@Path("system")
public interface IHealthCheck {

    @Path("/health")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    Map<String, Object> healthCheck();
}
