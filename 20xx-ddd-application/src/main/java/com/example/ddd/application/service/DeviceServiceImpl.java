package com.example.ddd.application.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.ddd.application.inter.IDeviceService;
import com.example.ddd.domain.device.aggregates.DeviceRoot;
import com.example.ddd.domain.device.entities.AttributeKvInfo;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.example.ddd.domain.device.repository.IDeviceRepository;
import com.example.ddd.dto.DeviceBean;
import com.example.ddd.infrastructure.repository.AttributeKvRepository;
import com.sie.iot.common.bean.PaginationRequestData;
import com.siefw.hibernate.core.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author Cool
 * @create 2020-11-16
 */

@Component("deviceServiceImpl")
public class DeviceServiceImpl implements IDeviceService {
    @Autowired
    private IDeviceRepository deviceRepository;
    @Autowired
    private AttributeKvRepository attributeKvRepository;

    @Override
    public DeviceRoot getByDeviceId(String deviceId) {
        DeviceInfo device = deviceRepository.getById(deviceId);
        List<AttributeKvInfo> attributeKvs = attributeKvRepository.findListByDeviceId(deviceId);
        DeviceRoot deviceRoot = new DeviceRoot();
        deviceRoot.setAttributeKvInfo(attributeKvs);
        deviceRoot.setDevice(device);
        return deviceRoot;
    }

    @Override
    public Pagination<DeviceInfo> findDevice(PaginationRequestData<DeviceBean> paginationRequestData) {
        DeviceBean params = paginationRequestData.getParams();
        Integer pageIndex = paginationRequestData.getPageIndex();
        Integer pageRows = paginationRequestData.getPageRows();
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        Pagination<DeviceInfo> devicePagination = deviceRepository.getDevicePagination(jsonObject, pageIndex, pageRows, paginationRequestData.getOrderByBean());
        return devicePagination;
    }
}