package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.TenantEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("tenantDAO_HI")
public class TenantDAO_HI extends BaseCommonDAO_HI<TenantEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(TenantDAO_HI.class);

	public TenantDAO_HI() {
		super();
	}

}
