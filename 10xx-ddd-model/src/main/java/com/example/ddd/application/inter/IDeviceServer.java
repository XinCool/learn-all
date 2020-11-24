package com.example.ddd.application.inter;


import com.example.ddd.dto.DeviceBean;
import com.sie.iot.common.bean.PaginationRequestData;
import com.sie.iot.common.bean.ResponseData;
import com.sie.iot.component.exception.ApplicationException;
import com.sie.iot.component.exception.ApplicationValidationException;

/**
 * @author Cool
 * @create 2020-11-16 13:56
 */
public interface IDeviceServer {
    /**
     * 查询设备及其对应的所有属性
     * @param paginationRequestData
     * @return
     * @throws ApplicationException
     */
    ResponseData findDevice(PaginationRequestData<DeviceBean> paginationRequestData) throws ApplicationException;

    /**
     * 根据设备Id查询设备信息及其属性
     * @param deviceId
     * @return
     */
    ResponseData getByDeviceId(String deviceId) throws ApplicationValidationException;
}
