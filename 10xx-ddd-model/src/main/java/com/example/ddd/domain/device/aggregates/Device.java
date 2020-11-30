package com.example.ddd.domain.device.aggregates;

import com.example.ddd.domain.device.entities.AttributeKvInfo;
import com.example.ddd.domain.device.entities.DeviceInfo;
import com.example.ddd.domain.device.vo.RelationInfo;
import lombok.Data;

import java.util.List;

/**
 * @author Cool
 * @create 2020-11-23 16:33
 */
@Data
public class Device {
    DeviceInfo device;
    List<AttributeKvInfo> attributeKvs;
    RelationInfo relation;
}
