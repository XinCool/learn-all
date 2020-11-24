package com.example.ddd.interfaces.controller;

import cn.hutool.core.util.StrUtil;
import com.example.ddd.application.inter.IDeviceService;
import com.example.ddd.domain.device.aggregates.DeviceRoot;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.example.ddd.dto.DeviceBean;
import com.sie.iot.common.bean.PaginationRequestData;
import com.sie.iot.common.bean.ResponseData;
import com.sie.iot.common.iotenum.ResponseMsgCode;
import com.sie.iot.common.model.inter.IBaseCommon;
import com.sie.iot.common.services.CommonAbstractService;
import com.sie.iot.component.exception.ApplicationException;
import com.sie.iot.component.exception.ApplicationRuntimeException;
import com.sie.iot.component.exception.ApplicationValidationException;
import com.siefw.hibernate.core.paging.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @create
 */
@RestController
@RequestMapping("/device")
@Api(value = "设备", tags = {"设备"})
public class DeviceController extends CommonAbstractService {
    @Autowired
    private IDeviceService deviceServiceImpl;

    @Override
    public IBaseCommon<?> getBaseCommonServer() {
        return null;
    }

    @ApiOperation(value = "根据设备id查询", notes = "获取设备 ", httpMethod = "GET")
    @GetMapping(value = "/get-device/{id}")
    public ResponseData getByDeviceId(@PathVariable("id") String deviceId) throws ApplicationValidationException {
        if (deviceId == null && StrUtil.isBlank(deviceId)) {
            throw new ApplicationValidationException(ResponseMsgCode.NOT_NULL_PARAM.msgCode);
        }
        try {
            DeviceRoot deviceRoot = deviceServiceImpl.getByDeviceId(deviceId);
            return new ResponseData(ResponseMsgCode.SUCCESS.msgCode, deviceRoot, redisTemplate);
        } catch (Exception e) {
            throw new ApplicationRuntimeException(ResponseMsgCode.ERROR.msgCode, e);
        }
    }

    @ApiOperation(value = "查询设备", notes = "查询设备 ", httpMethod = "POST")
    @PostMapping(value = "/find-device")
    public ResponseData findDevice(@RequestBody PaginationRequestData<DeviceBean> paginationRequestData) throws ApplicationException {
        try {
            Pagination<DeviceInfo> device = deviceServiceImpl.findDevice(paginationRequestData);
            return new ResponseData(ResponseMsgCode.SUCCESS.msgCode, device, redisTemplate);
        } catch (Exception e) {
            throw new ApplicationRuntimeException(ResponseMsgCode.ERROR.msgCode, e);
        }
    }

}
