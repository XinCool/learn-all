package com.example.ddd.application.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.ddd.application.inter.IDeviceService;
import com.example.ddd.domain.entities.AttributeKv;
import com.example.ddd.domain.entities.Device;
import com.example.ddd.domain.repository.IDeviceRepository;
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
    public JSONObject getByDeviceId(String deviceId) {
        Device device = deviceRepository.getById(deviceId);
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(device));
        List<AttributeKv> attributeKvs = attributeKvRepository.findListByDeviceId(deviceId);
        jsonObject.put("attributes", attributeKvs);
        return jsonObject;
    }

    @Override
    public Pagination<Device> findDevice(PaginationRequestData<DeviceBean> paginationRequestData) {
        DeviceBean params = paginationRequestData.getParams();
        Integer pageIndex = paginationRequestData.getPageIndex();
        Integer pageRows = paginationRequestData.getPageRows();
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        Pagination<Device> devicePagination = deviceRepository.getDevicePagination(jsonObject, pageIndex, pageRows, paginationRequestData.getOrderByBean());
        return devicePagination;
    }
}