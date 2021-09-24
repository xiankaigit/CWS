package com.xk.bigdata.cws.api;

import com.xk.bigdata.cws.common.beans.dto.req.BaseReqDTO;
import com.xk.bigdata.cws.common.beans.dto.req.data.*;
import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;
import com.xk.bigdata.cws.common.beans.dto.rsp.data.ItConfRespDTO;
import com.xk.bigdata.cws.common.beans.dto.rsp.data.ItRespDTO;

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
    BaseRspDTO<List<ItConfRespDTO>> listItConf(BaseReqDTO<ItConfQueryReqDTO> req);

    @Path("/it/conf/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    BaseRspDTO<ItConfRespDTO> saveOrUpdateItConf(BaseReqDTO<ItConfAddReqDTO> req);

    @Path("/it/conf/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    BaseRspDTO delItConf(BaseReqDTO<ItConfDelReqDTO> req);

    @Path("/it")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    BaseRspDTO<List<ItRespDTO>> listIts(BaseReqDTO<ItQueryReqDTO> req);


    @Path("/it/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    BaseRspDTO<ItRespDTO> addIt(BaseReqDTO<ItAddReqDTO> req);

    @Path("/it/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    BaseRspDTO deleteIt(BaseReqDTO<ItDelReqDTO> req);


}
