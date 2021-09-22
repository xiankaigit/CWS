package com.xk.bigdata.cws.moudles.business.service.impl;

import com.xk.bigdata.cws.common.beans.bo.ItConfBO;
import com.xk.bigdata.cws.common.tools.base.CwsUtils;
import com.xk.bigdata.cws.moudles.business.dao.ItConfDao;
import com.xk.bigdata.cws.moudles.business.dao.ItDao;
import com.xk.bigdata.cws.moudles.business.dao.entity.ItConfDO;
import com.xk.bigdata.cws.moudles.business.dao.entity.ItDO;
import com.xk.bigdata.cws.moudles.business.service.IClusterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午11:20
 */
@Service
public class ClusterServiceImpl implements IClusterService {

    private static Logger LOG = LoggerFactory.getLogger(ClusterServiceImpl.class);

    @Autowired
    private ItDao itDao;
    @Autowired
    private ItConfDao itConfDao;

    @Override
    public List<ItConfBO> getItConfByName(String name) {
        ItDO it = itDao.getByName(name);
        if(it == null){
            LOG.warn("not find interpreter for name {}",name);
            return Collections.emptyList();
        }

        Long itId = it.getId();
        List<ItConfDO> itConfS = itConfDao.getAllByItId(itId);
        List<ItConfBO> itConfBOList = CwsUtils.pojoListTrans(itConfS, ItConfBO.class);
        return itConfBOList;
    }
}
