package com.example.ddd.domain.responsitory.inter;

import com.alibaba.fastjson.JSONObject;
import com.example.ddd.domain.entities.DeviceEntity_HI;
import com.sie.iot.common.bean.OrderByBean;
import com.siefw.hibernate.core.paging.Pagination;

/**
 * @author
 * @create 2020-11-16 15:10
 */
public interface IDeviceResponsitory{
    /**
     * 分页查询设备
     * @param queryParamJSON
     * @param pageIndex
     * @param pageRows
     * @param orderBean
     * @return
     */
    Pagination<DeviceEntity_HI> findDevicePagination(JSONObject queryParamJSON, Integer pageIndex, Integer pageRows, OrderByBean orderBean);

    /**
     * 根据设备Id获取设备信息
     * @param id
     * @return
     */
    DeviceEntity_HI getById(String id);
}
