package com.xk.bigdata.cws.moudles.business.service;

import com.xk.bigdata.cws.common.beans.bo.ItBO;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/21 下午1:06
 */
public interface ItService {
    void findAll();
    ItBO getByName(String name);
}
