package com.xk.bigdata.cws.moudles.business.service;

import com.xk.bigdata.cws.common.beans.bo.ItBO;
import com.xk.bigdata.cws.common.beans.bo.ItConfBO;

import java.util.List;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午11:19
 */
public interface IClusterService {

    List<ItConfBO> getItConfByItId(Integer itId);

    ItConfBO saveOrUpdateItConf(Integer id, Integer itId,String name,String value,String remark);

    void delItConf(Integer id);

    List<ItBO> getItBoByKindAndUser(String kind,Integer userId);

    ItBO saveIt(String kind,String name ,String remark,Integer userId);

    void delIt(Integer id);

}
