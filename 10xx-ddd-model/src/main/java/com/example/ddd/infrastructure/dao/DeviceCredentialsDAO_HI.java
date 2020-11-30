package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.DeviceCredentialsEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("deviceCredentialsDAO_HI")
public class DeviceCredentialsDAO_HI extends BaseCommonDAO_HI<DeviceCredentialsEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceCredentialsDAO_HI.class);

	public DeviceCredentialsDAO_HI() {
		super();
	}

}
