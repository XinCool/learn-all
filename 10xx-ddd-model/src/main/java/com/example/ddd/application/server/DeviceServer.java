package com.example.ddd.application.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.ddd.application.inter.IDeviceServer;
import com.example.ddd.domain.entities.AttributeKvEntity_HI;
import com.example.ddd.domain.entities.DeviceEntity_HI;
import com.example.ddd.domain.responsitory.inter.IAttributeKvResponsitory;
import com.example.ddd.domain.responsitory.inter.IDeviceResponsitory;
import com.example.ddd.dto.DeviceBean;
import com.sie.iot.common.bean.PaginationRequestData;
import com.sie.iot.common.bean.ResponseData;
import com.sie.iot.common.iotenum.ResponseMsgCode;
import com.sie.iot.common.model.inter.IBaseCommon;
import com.sie.iot.common.services.CommonAbstractService;
import com.sie.iot.component.exception.ApplicationException;
import com.sie.iot.component.exception.ApplicationValidationException;
import com.siefw.hibernate.core.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("deviceServer")
public class DeviceServer extends CommonAbstractService implements IDeviceServer {
    @Autowired
    private IDeviceResponsitory deviceResponsitory;
    @Autowired
    private IAttributeKvResponsitory attributeKvResponsitory;

    @Override
    public ResponseData findDevice(PaginationRequestData<DeviceBean> paginationRequestData) throws ApplicationException {
        DeviceBean params = paginationRequestData.getParams();
        Integer pageIndex = paginationRequestData.getPageIndex();
        Integer pageRows = paginationRequestData.getPageRows();
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        Pagination<DeviceEntity_HI> devicePagination = deviceResponsitory.findDevicePagination(jsonObject, pageIndex, pageRows, paginationRequestData.getOrderByBean());
        return new ResponseData(ResponseMsgCode.SUCCESS.msgCode, devicePagination, redisTemplate);
    }

    @Override
    public ResponseData getByDeviceId(String deviceId) throws ApplicationValidationException {
        DeviceEntity_HI device = deviceResponsitory.getById(deviceId);
        List<AttributeKvEntity_HI> attributeKvEntityHis = attributeKvResponsitory.findByDeviceId(deviceId);
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(device));
        jsonObject.put("attributes", attributeKvEntityHis);
        return new ResponseData(ResponseMsgCode.SUCCESS.msgCode, jsonObject, redisTemplate);
    }

    @Override
    public IBaseCommon<?> getBaseCommonServer() {
        return null;
    }
}