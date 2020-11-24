package com.example.ddd.domain.device.repository;


import com.example.ddd.domain.device.entities.AttributeKvInfo;
import java.util.List;

/**
 * @author Cool
 * @create 2020-11-16
 */
public interface IAttributeKvRepository {
    /**
     * 根据设备ID查询kv
     *
     * @param deviceId
     * @return
     */
    List<AttributeKvInfo> findListByDeviceId(String deviceId);
}
