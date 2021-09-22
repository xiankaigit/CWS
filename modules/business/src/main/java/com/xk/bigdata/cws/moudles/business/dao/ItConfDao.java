package com.xk.bigdata.cws.moudles.business.dao;

import com.xk.bigdata.cws.moudles.business.dao.entity.ItConfDO;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/22 上午11:22
 */
public interface ItConfDao extends PagingAndSortingRepository<ItConfDO, Integer> {

    List<ItConfDO> getAllByItId(Long itId);

}
