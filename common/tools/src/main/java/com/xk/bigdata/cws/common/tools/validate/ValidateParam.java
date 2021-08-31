package com.xk.bigdata.cws.common.tools.validate;

import java.lang.annotation.*;

/**
  * @Description:      自动参数校验
  * @Author:          xiankai
  * @CreateDate:      2019/6/3 19:24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateParam {

}
