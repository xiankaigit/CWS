package com.xk.bigdata.cws.moudles.business.dao;
import com.xk.bigdata.cws.moudles.business.dao.entity.ItDO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ：xiankai
 * @date ：Created in 2021/9/21 下午1:08
 */
public interface ItDao extends PagingAndSortingRepository<ItDO, Integer> {

    ItDO getByName(String name);

    void deleteByName(String name);


}
