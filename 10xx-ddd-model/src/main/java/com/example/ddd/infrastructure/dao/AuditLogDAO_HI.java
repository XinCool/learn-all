package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.AuditLogEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("auditLogDAO_HI")
public class AuditLogDAO_HI extends BaseCommonDAO_HI<AuditLogEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuditLogDAO_HI.class);

	public AuditLogDAO_HI() {
		super();
	}

}
