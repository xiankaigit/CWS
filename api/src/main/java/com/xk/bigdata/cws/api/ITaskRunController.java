package com.xk.bigdata.cws.api;

import com.xk.bigdata.cws.common.beans.dto.req.BaseReqDTO;
import com.xk.bigdata.cws.common.beans.dto.req.data.RunSqlParamDTO;
import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/18 下午8:09
 */

@Path("/cws/rest/task/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ITaskRunController {

    @Path("/sql")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    BaseRspDTO runSql(BaseReqDTO<RunSqlParamDTO> req);
}
