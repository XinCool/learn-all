package com.example.ddd.application.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.ddd.application.inter.IDeviceAppService;
import com.example.ddd.domain.device.aggregates.Device;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.example.ddd.domain.device.repository.IDeviceRepository;
import com.example.ddd.domain.device.service.IDeviceService;
import com.example.ddd.dto.DeviceBean;
import com.example.ddd.infrastructure.repository.RelationRepository;
import com.example.ddd.interfaces.assembler.DeviceAssembler;
import com.sie.iot.common.bean.OrderByBean;
import com.sie.iot.common.bean.PaginationRequestData;
import com.siefw.hibernate.core.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author Cool
 * @create 2020-11-16
 */

@Component("deviceAppService")
public class DeviceAppService implements IDeviceAppService {
    @Autowired
    private IDeviceRepository deviceRepository;
    @Autowired
    private RelationRepository relationRepository;
    @Autowired
    private IDeviceService deviceService;

    @Override
    public Device getByDeviceId(String deviceId) {
        return deviceService.getByDeviceId(deviceId);
    }

    @Override
    public Pagination<DeviceInfo> findDevice(PaginationRequestData<DeviceBean> paginationRequestData) {
        DeviceBean params = paginationRequestData.getParams();
        Integer pageIndex = paginationRequestData.getPageIndex();
        Integer pageRows = paginationRequestData.getPageRows();
        OrderByBean orderByBean = paginationRequestData.getOrderByBean();
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        return deviceService.findDevice(jsonObject,pageIndex,pageRows,orderByBean);
    }

    @Override
    public Pagination<Device> findDeviceKvParent(PaginationRequestData<DeviceAssembler> paginationRequestData) {
        DeviceAssembler params = paginationRequestData.getParams();
        Integer pageIndex = paginationRequestData.getPageIndex();
        Integer pageRows = paginationRequestData.getPageRows();
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        return deviceService.findDeviceKvParent(jsonObject, pageIndex, pageRows, paginationRequestData.getOrderByBean());
    }
}