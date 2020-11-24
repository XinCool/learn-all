package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.RelationEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("relationDAO_HI")
public class RelationDAO_HI extends BaseCommonDAO_HI<RelationEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(RelationDAO_HI.class);

	public RelationDAO_HI() {
		super();
	}

}
