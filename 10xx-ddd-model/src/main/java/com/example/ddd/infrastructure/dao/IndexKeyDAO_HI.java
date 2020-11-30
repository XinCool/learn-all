package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.IndexKeyEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("indexKeyDAO_HI")
public class IndexKeyDAO_HI extends BaseCommonDAO_HI<IndexKeyEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexKeyDAO_HI.class);

	public IndexKeyDAO_HI() {
		super();
	}

}
