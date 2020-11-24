package com.example.ddd.domain.responsitory.inter;


import com.example.ddd.domain.entities.AttributeKvEntity_HI;

import java.util.List;

/**
 * @author
 * @create 2020-11-16 15:10
 */
public interface IAttributeKvResponsitory {
    /**
     * 根据设备id查询其所有属性
     * @param deviceId
     * @return
     */
    List<AttributeKvEntity_HI> findByDeviceId(String deviceId);
}
