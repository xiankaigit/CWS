package com.xk.bigdata.cws.modules.provider;

import com.xk.bigdata.cws.api.IClusterController;
import com.xk.bigdata.cws.common.beans.bo.ItConfBO;
import com.xk.bigdata.cws.common.beans.dto.req.BaseReqDTO;
import com.xk.bigdata.cws.common.beans.dto.req.data.ItConfParam;
import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;
import com.xk.bigdata.cws.common.beans.dto.rsp.data.ItConfDTO;
import com.xk.bigdata.cws.common.tools.base.CwsUtils;
import com.xk.bigdata.cws.moudles.business.service.IClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午11:16
 */
@Controller
public class ClusterControllerImpl implements IClusterController {

    @Autowired
    private IClusterService clusterService;

    @Override
    public BaseRspDTO<List<ItConfDTO>> runSql(BaseReqDTO<ItConfParam> req) {
        ItConfParam data = req.getData();
        String name = data.getName();
        List<ItConfBO> itConfBOS = clusterService.getItConfByName(name);
        List<ItConfDTO> itConfDTOS = CwsUtils.pojoListTrans(itConfBOS, ItConfDTO.class);
        BaseRspDTO<List<ItConfDTO>> successResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createSuccessResponse(itConfDTOS);
        return successResponse;
    }

}
