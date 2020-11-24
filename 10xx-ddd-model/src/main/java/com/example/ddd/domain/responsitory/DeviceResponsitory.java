package com.example.ddd.domain.responsitory;

import com.alibaba.fastjson.JSONObject;
import com.example.ddd.domain.entities.DeviceEntity_HI;
import com.example.ddd.domain.responsitory.inter.IDeviceResponsitory;
import com.google.common.collect.Maps;
import com.sie.iot.common.bean.OrderByBean;
import com.siefw.hibernate.core.dao.ViewObject;
import com.siefw.hibernate.core.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("deviceResponsitory")
public class DeviceResponsitory implements IDeviceResponsitory {

    @Autowired
    private ViewObject<DeviceEntity_HI> deviceDAO_HI;

    @Override
    public Pagination<DeviceEntity_HI> findDevicePagination(JSONObject queryParamJSON, Integer pageIndex, Integer pageRows, OrderByBean orderBean) {
        Map<String, Object> params = Maps.newHashMap();
        Pagination<DeviceEntity_HI> deviceEntity_HI = deviceDAO_HI.findPagination(" order by a.creation_date desc"+ " order by a.creation_date desc", params, pageIndex, pageRows);
        return deviceEntity_HI;
    }

    /**
     * 根据设备Id设备信息
     * @param id
     * @return
     */
    @Override
    public DeviceEntity_HI getById(String id) {
        return deviceDAO_HI.getById(id);
    }
}
