package com.example.ddd.application.inter;


import com.example.ddd.domain.device.aggregates.DeviceRoot;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.example.ddd.dto.DeviceBean;
import com.sie.iot.common.bean.PaginationRequestData;
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
    DeviceRoot getByDeviceId(String deviceId);

    /**
     * 分页查询设备
     *
     * @param paginationRequestData
     * @return
     * @throws ApplicationException
     */
    Pagination<DeviceInfo> findDevice(PaginationRequestData<DeviceBean> paginationRequestData);

}
