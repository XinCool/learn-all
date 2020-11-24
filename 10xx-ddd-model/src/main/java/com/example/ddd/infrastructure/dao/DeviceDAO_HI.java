package com.example.ddd.infrastructure.dao;


import com.example.ddd.infrastructure.entities.DeviceEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Cool
 * @create 2020-11-16
 */
@Component("deviceDAO_HI")
public class DeviceDAO_HI extends BaseCommonDAO_HI<DeviceEntity_HI> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceDAO_HI.class);

    public DeviceDAO_HI() {
        super();
    }


}
