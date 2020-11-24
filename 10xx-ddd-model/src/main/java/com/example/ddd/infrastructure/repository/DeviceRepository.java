package com.example.ddd.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.example.ddd.domain.device.repository.IDeviceRepository;
import com.example.ddd.infrastructure.entities.DeviceEntity_HI;
import com.sie.iot.common.bean.OrderByBean;
import com.sie.iot.common.util.SaafToolUtils;
import com.siefw.base.utils.SToolUtils;
import com.siefw.hibernate.core.dao.ViewObject;
import com.siefw.hibernate.core.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cool
 * @create 2020-11-16
 */
@Component("deviceRepository")
public class DeviceRepository implements IDeviceRepository {

    @Autowired
    private ViewObject<DeviceEntity_HI> deviceDAO_HI;

    @Override
    public Pagination<DeviceInfo> getDevicePagination(JSONObject queryParamJSON, Integer pageIndex, Integer pageRows, OrderByBean orderBean) {
        Map<String, Object> paramsMap;
        if (queryParamJSON != null) {
            paramsMap = SToolUtils.fastJsonObj2Map(queryParamJSON);
        } else {
            paramsMap = new HashMap<>();
        }
        StringBuffer querySQLSB = new StringBuffer(" from DeviceEntity_HI where 1=1 ");
        if (orderBean != null) {
            SaafToolUtils.sortUtil(orderBean, querySQLSB);
        }
        Pagination<DeviceEntity_HI> entityPagination = deviceDAO_HI.findPagination(querySQLSB.toString(), paramsMap, pageIndex, pageRows);
        Pagination<DeviceInfo> devicePagination = new Pagination<>();
        BeanUtil.copyProperties(entityPagination, devicePagination);
        return devicePagination;
    }

    /**
     * 根据设备Id设备信息
     *
     * @param id
     * @return
     */
    @Override
    public DeviceInfo getById(String id) {
        DeviceEntity_HI deviceEntityHI = deviceDAO_HI.getById(id);
        DeviceInfo device = new DeviceInfo();
        BeanUtil.copyProperties(deviceEntityHI, device);
        return device;
    }
}
