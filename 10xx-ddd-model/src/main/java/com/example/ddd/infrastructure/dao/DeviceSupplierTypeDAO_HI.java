package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.DeviceSupplierTypeEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("deviceSupplierTypeDAO_HI")
public class DeviceSupplierTypeDAO_HI extends BaseCommonDAO_HI<DeviceSupplierTypeEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceSupplierTypeDAO_HI.class);

	public DeviceSupplierTypeDAO_HI() {
		super();
	}

}
