package com.xk.bigdata.cws;

import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("system")
public interface IHealthCheck {

    @Path("/health")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    Map<String, Object> healthCheck(Map<String,Object> data);
}
