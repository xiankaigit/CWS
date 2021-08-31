package com.xk.bigdata.cws.common.tools.validate;

import com.xk.bigdata.cws.common.beans.dto.req.BaseReqDTO;
import com.xk.bigdata.cws.common.beans.dto.req.ParamValidateAble;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @Description: 自动参数校验
 * @Author: xiankai
 * @CreateDate: 2019/6/3 19:24
 */
@Aspect
@Component
public class ValidateParamAspect {

    private static Logger LOG = LoggerFactory.getLogger(ValidateParam.class);


    @Before(value = "@annotation(ValidateParam)")
    public void validateParam(JoinPoint point) {
        Object[] vals = point.getArgs();
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        if (parameterNames == null || parameterNames.length == 0) {
            LOG.info("method has no parameters");
        }
        for (int i = 0, len = parameterNames.length; i < len; i++) {
            String name = parameterNames[i];
            Object val = vals[i];
            if (val instanceof BaseReqDTO) {
                BaseReqDTO reqDTO = (BaseReqDTO) val;
                ParamValidateAble bigData = reqDTO.getData();
                bigData.validateParam();
            } else {//除了BaseReqDTO这种类型的参数外，暂定其他参数为必填参数,后续可以考虑自定义注解，根据注解进行非空等校验[注解可以通过上面注释掉的method获得]
                if (val == null) {
                    LOG.info("parameter lack error, parameter is {}", name);
                    throw new ValidateParamException("lack require param: " + name);
                }
            }
        }
    }
}
