package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.DeviceTypeEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("deviceTypeDAO_HI")
public class DeviceTypeDAO_HI extends BaseCommonDAO_HI<DeviceTypeEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceTypeDAO_HI.class);

	public DeviceTypeDAO_HI() {
		super();
	}

}
