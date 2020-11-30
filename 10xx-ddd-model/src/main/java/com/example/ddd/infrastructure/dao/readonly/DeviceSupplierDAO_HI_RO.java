package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.DeviceSupplierEntity_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("deviceSupplierDAO_HI_RO")
public class DeviceSupplierDAO_HI_RO extends DynamicViewObjectImpl<DeviceSupplierEntity_HI_RO>  {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceSupplierDAO_HI_RO.class);
	public DeviceSupplierDAO_HI_RO() {
		super();
	}

}
