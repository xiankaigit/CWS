package com.xk.bigdata.cws.start.handle;

import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;
import com.xk.bigdata.cws.common.beans.exception.CwsException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/18 下午7:56
 */
public class GlobalExeHandle implements ExceptionMapper<CwsException> {
    @Override
    public Response toResponse(CwsException e) {
        BaseRspDTO failResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createFailResponse(null, e.getCode(), e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(failResponse).build();
    }
}
