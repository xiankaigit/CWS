package com.xk.bigdata.cws.moudles.business.service.impl;

import com.xk.bigdata.cws.common.beans.bo.ItBO;
import com.xk.bigdata.cws.common.beans.bo.ItConfBO;
import com.xk.bigdata.cws.common.beans.exception.DBExeception;
import com.xk.bigdata.cws.common.tools.utils.CwsUtils;
import com.xk.bigdata.cws.moudles.business.dao.ItConfDao;
import com.xk.bigdata.cws.moudles.business.dao.ItDao;
import com.xk.bigdata.cws.moudles.business.dao.entity.ItConfDO;
import com.xk.bigdata.cws.moudles.business.dao.entity.ItDO;
import com.xk.bigdata.cws.moudles.business.service.IClusterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午11:20
 */
@Service
@Transactional
public class ClusterServiceImpl implements IClusterService {

    private static Logger LOG = LoggerFactory.getLogger(ClusterServiceImpl.class);

    @Autowired
    private ItDao itDao;

    @Autowired
    private ItConfDao itConfDao;

    @Override
    public List<ItConfBO> getItConfByItId(Integer itId) {
        List<ItConfDO> itConfS = itConfDao.getAllByItId(itId);
        List<ItConfBO> itConfBOList = CwsUtils.pojoListTrans(itConfS, ItConfBO.class);
        return itConfBOList;
    }

    @Override
    public ItConfBO saveOrUpdateItConf(Integer id, Integer itId, String name, String value, String remark) {
        ItConfDO itConfDO = new ItConfDO(id,name, value, itId, remark);
        itConfDO = itConfDao.save(itConfDO);
        ItConfBO itBO = CwsUtils.pojoTrans(itConfDO, ItConfBO.class);
        return itBO;
    }

    @Override
    public void delItConf(Integer id) {
        itConfDao.deleteById(id);
    }

    @Override
    public List<ItBO> getItBoByKindAndUser(String kind, Integer userId) {
        List<ItDO> itDOs = null;
        if (userId == null) {
            if (StringUtils.isEmpty(kind) || "all".equals(kind))
                itDOs = (List<ItDO>) itDao.findAll();
            else
                itDOs = itDao.getAllByKind(kind);
        } else {
            if (StringUtils.isEmpty(kind) || "all".equals(kind))
                itDOs = itDao.getAllByUserId(userId);
            else
                itDOs = itDao.getAllByUserIdAndKind(userId, kind);

        }
        List<ItBO> itBOs = CwsUtils.pojoListTrans(itDOs, ItBO.class);
        return itBOs;
    }

    @Override
    public ItBO saveIt(String kind, String name, String remark, Integer userId) {
        ItDO it = new ItDO(kind, name, userId, remark);
        try {
            it = itDao.save(it);
            ItBO itBO = CwsUtils.pojoTrans(it, ItBO.class);
            return itBO;
        } catch (JpaSystemException e) {
            throw new DBExeception("保存执行器失败, 可能存在相同名称的执行器, 请更换名称后重试!");
        }
    }

    @Override
    public void delIt(Integer id) {
        itDao.deleteById(id);
        itConfDao.deleteAllByItId(id);
    }
}
