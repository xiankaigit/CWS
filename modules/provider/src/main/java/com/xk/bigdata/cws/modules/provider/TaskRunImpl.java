package com.xk.bigdata.cws.modules.provider;

import com.xk.bigdata.cws.api.TaskRun;
import com.xk.bigdata.cws.common.beans.dto.req.BaseReqDTO;
import com.xk.bigdata.cws.common.beans.dto.req.data.RunSqlParam;
import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;
import com.xk.bigdata.cws.common.tools.validate.ValidateParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/18 下午8:17
 */
@Controller
public class TaskRunImpl implements TaskRun {

    private static Logger LOG = LoggerFactory.getLogger(TaskRunImpl.class);
    @Override
    @ValidateParam
    public BaseRspDTO runSql(BaseReqDTO<RunSqlParam> req) {
        String sql = req.getData().getSql();
        LOG.info("run sql {}", sql);
        BaseRspDTO<Object> resp = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createFailResponse(null, 1, "异步任务已提交，可在任务监控查看任务状态！");
        return resp;
    }
}
