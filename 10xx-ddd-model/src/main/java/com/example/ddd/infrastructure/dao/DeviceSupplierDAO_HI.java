package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.DeviceSupplierEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("deviceSupplierDAO_HI")
public class DeviceSupplierDAO_HI extends BaseCommonDAO_HI<DeviceSupplierEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceSupplierDAO_HI.class);

	public DeviceSupplierDAO_HI() {
		super();
	}

}
