package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.DeviceUpgradeLogEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("deviceUpgradeLogDAO_HI")
public class DeviceUpgradeLogDAO_HI extends BaseCommonDAO_HI<DeviceUpgradeLogEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceUpgradeLogDAO_HI.class);

	public DeviceUpgradeLogDAO_HI() {
		super();
	}

}
