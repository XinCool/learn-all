package com.example.ddd.domain.repository;

import com.example.ddd.domain.entities.AttributeKv;

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
    List<AttributeKv> findListByDeviceId(String deviceId);
}
