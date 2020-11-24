package com.example.ddd.interfaces.controller;

import cn.hutool.core.util.StrUtil;
import com.example.ddd.application.inter.IDeviceServer;
import com.example.ddd.dto.DeviceBean;
import com.sie.iot.common.bean.PaginationRequestData;
import com.sie.iot.common.bean.ResponseData;
import com.sie.iot.common.iotenum.ResponseMsgCode;
import com.sie.iot.common.model.inter.IBaseCommon;
import com.sie.iot.common.services.CommonAbstractService;
import com.sie.iot.component.exception.ApplicationException;
import com.sie.iot.component.exception.ApplicationRuntimeException;
import com.sie.iot.component.exception.ApplicationValidationException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Cool
 * @create 2020-11-16 13:51
 */
@RestController
@RequestMapping("/device")
public class DeviceController extends CommonAbstractService {
    @Autowired
    private IDeviceServer deviceServer;

    @Override
    public IBaseCommon<?> getBaseCommonServer() {
        return null;
    }

    @ApiOperation(value = "查询设备", notes = "查询设备 ", httpMethod = "POST")
    @PostMapping(value = "/find-device")
    public ResponseData findDevice(@RequestBody PaginationRequestData<DeviceBean> paginationRequestData) throws ApplicationException {
        try {
            ResponseData device = deviceServer.findDevice(paginationRequestData);
            return device;
        } catch (Exception e) {
            throw new ApplicationRuntimeException(ResponseMsgCode.ERROR.msgCode, e);
        }
    }


    @ApiOperation(value = "根据设备id查询", notes = "获取设备 ", httpMethod = "get")
    @PostMapping(value = "/find-device/{deviceId}")
    public ResponseData getByDeviceId(@PathVariable("deviceId")String deviceId) throws ApplicationValidationException {
        if (deviceId == null && StrUtil.isBlank(deviceId)) {
            throw new ApplicationValidationException(ResponseMsgCode.NOT_NULL_PARAM.msgCode);
        }
        try {
            ResponseData device = deviceServer.getByDeviceId(deviceId);
            return device;
        } catch (Exception e) {
            throw new ApplicationRuntimeException(ResponseMsgCode.ERROR.msgCode, e);
        }
    }
}
