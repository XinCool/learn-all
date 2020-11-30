package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.VersionEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("versionDAO_HI")
public class VersionDAO_HI extends BaseCommonDAO_HI<VersionEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(VersionDAO_HI.class);

	public VersionDAO_HI() {
		super();
	}

}
