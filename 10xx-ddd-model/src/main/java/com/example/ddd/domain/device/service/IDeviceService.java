package com.example.ddd.domain.device.service;


import com.alibaba.fastjson.JSONObject;
import com.example.ddd.domain.device.aggregates.Device;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.sie.iot.common.bean.OrderByBean;
import com.sie.iot.component.exception.ApplicationException;
import com.siefw.hibernate.core.paging.Pagination;

/**
 * @author Cool
 * @create 2020-11-16
 */
public interface IDeviceService {
    /**
     * 根据设备Id查询设备信息
     *
     * @param deviceId
     * @return
     */
    Device getByDeviceId(String deviceId);

    /**
     * 分页查询设备：设备信息
     *
     * @param
     * @return
     * @throws ApplicationException
     */
    Pagination<DeviceInfo> findDevice(JSONObject params, Integer pageIndex, Integer pageRows, OrderByBean orderBean);

    /**
     * 分页查询设备：设备信息、设备属性、父级设备
     * @param
     * @return
     */
    Pagination<Device> findDeviceKvParent(JSONObject params, Integer pageIndex, Integer pageRows, OrderByBean orderBean);
}
