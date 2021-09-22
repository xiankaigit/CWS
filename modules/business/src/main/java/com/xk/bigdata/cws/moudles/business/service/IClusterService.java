package com.xk.bigdata.cws.moudles.business.service;

import com.xk.bigdata.cws.common.beans.bo.ItConfBO;

import java.util.List;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午11:19
 */
public interface IClusterService {

    List<ItConfBO> getItConfByName(String name);

}
