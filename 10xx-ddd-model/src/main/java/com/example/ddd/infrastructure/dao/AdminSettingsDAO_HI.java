package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.AdminSettingsEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("adminSettingsDAO_HI")
public class AdminSettingsDAO_HI extends BaseCommonDAO_HI<AdminSettingsEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminSettingsDAO_HI.class);

	public AdminSettingsDAO_HI() {
		super();
	}

}
