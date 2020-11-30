package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.TagEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("tagDAO_HI")
public class TagDAO_HI extends BaseCommonDAO_HI<TagEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(TagDAO_HI.class);

	public TagDAO_HI() {
		super();
	}

}
