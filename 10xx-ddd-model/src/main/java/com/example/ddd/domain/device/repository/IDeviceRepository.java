package com.example.ddd.domain.device.repository;

import com.alibaba.fastjson.JSONObject;
import com.example.ddd.domain.device.aggregates.Device;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.sie.iot.common.bean.OrderByBean;
import com.siefw.hibernate.core.paging.Pagination;

/**
 * @author Cool
 * @create 2020-11-16
 */
public interface IDeviceRepository {
    /**
     * 分页查询设备：设备信息
     *
     * @param queryParamJSON
     * @param pageIndex
     * @param pageRows
     * @param orderBean
     * @return
     */
    Pagination<DeviceInfo> getDevicePagination(JSONObject queryParamJSON, Integer pageIndex, Integer pageRows, OrderByBean orderBean);

    /**
     * 根据设备Id获取设备信息
     *
     * @param id
     * @return
     */
    DeviceInfo getById(String id);

    /**
     * 分页查询设备：设备信息、设备属性、父级设备
     * @param queryParamJSON
     * @param pageIndex
     * @param pageRows
     * @param orderBean
     * @return
     */
    Pagination<Device> findDeviceKvParent(JSONObject queryParamJSON, Integer pageIndex, Integer pageRows, OrderByBean orderBean);
}
