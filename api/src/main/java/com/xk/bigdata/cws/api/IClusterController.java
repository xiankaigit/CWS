package com.xk.bigdata.cws.api;

import com.xk.bigdata.cws.common.beans.dto.req.BaseReqDTO;
import com.xk.bigdata.cws.common.beans.dto.req.data.ItConfParam;
import com.xk.bigdata.cws.common.beans.dto.req.data.RunSqlParamDTO;
import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;
import com.xk.bigdata.cws.common.beans.dto.rsp.data.ItConfDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午11:12
 */
@Path("/cws/rest/cluster/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IClusterController {

    @Path("/it/conf")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    BaseRspDTO<List<ItConfDTO>> runSql(BaseReqDTO<ItConfParam> req);

}
