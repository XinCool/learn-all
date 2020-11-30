package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.VersionEntity_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("versionDAO_HI_RO")
public class VersionDAO_HI_RO extends DynamicViewObjectImpl<VersionEntity_HI_RO>  {
	private static final Logger LOGGER = LoggerFactory.getLogger(VersionDAO_HI_RO.class);
	public VersionDAO_HI_RO() {
		super();
	}

}
