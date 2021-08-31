package com.xk.bigdata.cws.common.tools.validate;

import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;
import org.springframework.stereotype.Component;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * @Description:      自动参数校验
 * @Author:          xiankai
 * @CreateDate:      2019/6/3 19:24
 */
@Provider
@Component
public class ValidateParamExceptionHandler implements ExceptionMapper<ValidateParamException> {

    @Override
    public Response toResponse(ValidateParamException e) {
        BaseRspDTO failResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createFailResponse(null, 0x00000003, e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(failResponse).build();
    }

}
