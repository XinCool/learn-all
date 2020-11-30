package com.example.ddd.domain.device.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.ddd.domain.device.aggregates.Device;
import com.example.ddd.domain.device.entities.AttributeKvInfo;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.example.ddd.domain.device.repository.IDeviceRepository;
import com.example.ddd.domain.device.service.IDeviceService;
import com.example.ddd.infrastructure.repository.AttributeKvRepository;
import com.example.ddd.infrastructure.repository.RelationRepository;
import com.sie.iot.common.bean.OrderByBean;
import com.siefw.hibernate.core.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author Cool
 * @create 2020-11-16
 */

@Component("deviceService")
public class DeviceServiceImpl implements IDeviceService {
    @Autowired
    private IDeviceRepository deviceRepository;
    @Autowired
    private AttributeKvRepository attributeKvRepository;
    @Autowired
    private RelationRepository relationRepository;

    @Override
    public Device getByDeviceId(String deviceId) {
        DeviceInfo device = deviceRepository.getById(deviceId);
        List<AttributeKvInfo> attributeKvs = attributeKvRepository.findListByDeviceId(deviceId);
        Device deviceRoot = new Device();
        deviceRoot.setAttributeKvs(attributeKvs);
        deviceRoot.setDevice(device);
        return deviceRoot;
    }

    @Override
    public Pagination<DeviceInfo> findDevice(JSONObject params, Integer pageIndex, Integer pageRows, OrderByBean orderBean) {
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        Pagination<DeviceInfo> devicePagination = deviceRepository.getDevicePagination(jsonObject, pageIndex, pageRows, orderBean);
        return devicePagination;
    }

    @Override
    public Pagination<Device> findDeviceKvParent(JSONObject params, Integer pageIndex, Integer pageRows, OrderByBean orderBean) {
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        Pagination<Device> devicePagination = deviceRepository.findDeviceKvParent(jsonObject, pageIndex, pageRows, orderBean);
        return devicePagination;
    }
}