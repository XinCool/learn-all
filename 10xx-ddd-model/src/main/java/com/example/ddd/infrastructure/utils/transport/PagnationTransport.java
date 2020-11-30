package com.example.ddd.infrastructure.utils.transport;

import cn.hutool.core.bean.BeanUtil;
import com.siefw.hibernate.core.paging.Pagination;

/**
 * @author Cool
 * @create 2020-11-25 9:32
 */
public class PagnationTransport<T extends Object,E extends Object> {
    public Pagination<E> paginationUtil(Pagination<T> pagination){
        Pagination<E> resultPagnation = new Pagination<>();
        BeanUtil.copyProperties(pagination,resultPagnation, "data");

        //data


        return resultPagnation;
    }
}
