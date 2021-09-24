package com.xk.bigdata.cws.modules.provider;

import com.alibaba.fastjson.JSONObject;
import com.xk.bigdata.cws.api.ITaskRunController;
import com.xk.bigdata.cws.common.beans.bo.ItBO;
import com.xk.bigdata.cws.common.beans.dto.req.BaseReqDTO;
import com.xk.bigdata.cws.common.beans.dto.req.data.RunSqlReqDTO;
import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;
import com.xk.bigdata.cws.common.tools.validate.ValidateParam;
import com.xk.bigdata.cws.moudles.business.service.ItService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/18 下午8:17
 */
@Controller
public class TaskRunnerControllerImpl implements ITaskRunController {

    private static Logger LOG = LoggerFactory.getLogger(TaskRunnerControllerImpl.class);

    @Autowired
    private ItService itService;

    @Override
    @ValidateParam
    public BaseRspDTO runSql(BaseReqDTO<RunSqlReqDTO> req) {
        String sql = req.getData().getSql();
        LOG.info("run sql {}", sql);
        BaseRspDTO<Object> resp = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createFailResponse(null, 1, "异步任务已提交，可在任务监控查看任务状态！");
        return resp;
    }
}
