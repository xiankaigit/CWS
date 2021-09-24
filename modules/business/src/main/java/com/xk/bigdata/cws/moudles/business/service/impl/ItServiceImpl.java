package com.xk.bigdata.cws.moudles.business.service.impl;

import com.xk.bigdata.cws.common.beans.bo.ItBO;
import com.xk.bigdata.cws.common.tools.utils.CwsUtils;
import com.xk.bigdata.cws.moudles.business.dao.ItDao;
import com.xk.bigdata.cws.moudles.business.dao.entity.ItDO;
import com.xk.bigdata.cws.moudles.business.service.ItService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/21 下午1:06
 */
@Service
public class ItServiceImpl implements ItService {

    @Autowired
    private ItDao interpreterDao;

    @Override
    public void findAll() {

    }

    @Override
    public ItBO getByName(String name) {
        ItDO it = interpreterDao.getByName(name);
        ItBO interpreterBO = CwsUtils.pojoTrans(it, ItBO.class);
        return interpreterBO;
    }
}
