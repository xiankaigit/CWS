package com.xk.bigdata.cws.modules.provider;

import com.xk.bigdata.cws.api.IClusterController;
import com.xk.bigdata.cws.common.beans.bo.ItBO;
import com.xk.bigdata.cws.common.beans.bo.ItConfBO;
import com.xk.bigdata.cws.common.beans.dto.req.BaseReqDTO;
import com.xk.bigdata.cws.common.beans.dto.req.data.*;
import com.xk.bigdata.cws.common.beans.dto.rsp.BaseRspDTO;
import com.xk.bigdata.cws.common.beans.dto.rsp.data.ItConfRespDTO;
import com.xk.bigdata.cws.common.beans.dto.rsp.data.ItRespDTO;
import com.xk.bigdata.cws.common.tools.utils.CwsUtils;
import com.xk.bigdata.cws.common.tools.validate.ValidateParam;
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
    @ValidateParam
    public BaseRspDTO<List<ItConfRespDTO>> listItConf(BaseReqDTO<ItConfQueryReqDTO> req) {
        ItConfQueryReqDTO data = req.getData();
        Integer itId = data.getItId();
        List<ItConfBO> itConfBOS = clusterService.getItConfByItId(itId);
        List<ItConfRespDTO> itConfDTOS = CwsUtils.pojoListTrans(itConfBOS, ItConfRespDTO.class);
        BaseRspDTO<List<ItConfRespDTO>> successResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createSuccessResponse(itConfDTOS);
        return successResponse;
    }

    @Override
    @ValidateParam
    public BaseRspDTO<ItConfRespDTO> saveOrUpdateItConf(BaseReqDTO<ItConfAddReqDTO> req) {
        ItConfAddReqDTO data = req.getData();
        Integer id = data.getId();
        Integer itId = data.getItId();
        String name = data.getName();
        String value = data.getValue();
        String remark = data.getRemark();
        ItConfBO itConfBO = clusterService.saveOrUpdateItConf(id,itId, name, value, remark);
        ItConfRespDTO itConfDTOS = CwsUtils.pojoTrans(itConfBO, ItConfRespDTO.class);
        BaseRspDTO<ItConfRespDTO> successResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createSuccessResponse(itConfDTOS);
        return successResponse;
    }

    @Override
    public BaseRspDTO delItConf(BaseReqDTO<ItConfDelReqDTO> req) {
        Integer id = req.getData().getId();
        clusterService.delItConf(id);
        BaseRspDTO successResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createSuccessResponse(null);
        return successResponse;
    }

    @Override
    public BaseRspDTO<List<ItRespDTO>> listIts(BaseReqDTO<ItQueryReqDTO> req) {
        Integer userId = CwsUtils.getUserId();
        String kind = req.getData().getKind();
        if (kind == null || "".equals(kind))
            kind = "all";
        List<ItBO> itBos = clusterService.getItBoByKindAndUser(kind, userId);
        List<ItRespDTO> itDTOs = CwsUtils.pojoListTrans(itBos, ItRespDTO.class);
        BaseRspDTO<List<ItRespDTO>> successResponse = BaseRspDTO.BaseRspDTOFactory.INSTANCE.createSuccessResponse(itDTOs);
        return successResponse;
    }

    @Override
    public BaseRspDTO<ItRespDTO> addIt(BaseReqDTO<ItAddReqDTO> req) {
        Integer userId = CwsUtils.getUserId();
        ItAddReqDTO data = req.getData();
        String kind = data.getKind();
        String name = data.getName();
        String remark = data.getRemark();
        ItBO itBO = clusterService.saveIt(kind, name, remark, userId);
        ItRespDTO itRespDTO = CwsUtils.pojoTrans(itBO, ItRespDTO.class);
        return BaseRspDTO.BaseRspDTOFactory.INSTANCE.createSuccessResponse(itRespDTO);
    }

    @Override
    public BaseRspDTO deleteIt(BaseReqDTO<ItDelReqDTO> req) {
        Integer id = req.getData().getId();
        clusterService.delIt(id);
        return BaseRspDTO.BaseRspDTOFactory.INSTANCE.createSuccessResponse(null);
    }

}
