package com.xk.bigdata.cws.start.handle;

import com.xk.bigdata.cws.common.beans.dto.ValidateError;
import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;
import com.xk.bigdata.cws.common.beans.exception.CwsException;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/18 下午7:56
 */
@Provider
@Component
public class GlobalExeHandle implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException e) {
        if (e instanceof CwsException) {
            CwsException ce = (CwsException) e;
            BaseRspDTO failResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createFailResponse(null, ce.getCode(), e.getMessage());
            return Response.status(Response.Status.OK).entity(failResponse).build();
        } else if (e instanceof ValidateError) {
            ValidateError ve = (ValidateError) e;
            BaseRspDTO failResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createFailResponse(null, 3, e.getMessage());
            return Response.status(Response.Status.OK).entity(failResponse).build();
        } else {
            BaseRspDTO failResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createFailResponse(null, 4, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(failResponse).build();
        }
    }
}
