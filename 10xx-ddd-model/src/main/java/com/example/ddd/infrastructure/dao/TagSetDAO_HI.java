package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.TagSetEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("tagSetDAO_HI")
public class TagSetDAO_HI extends BaseCommonDAO_HI<TagSetEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(TagSetDAO_HI.class);

	public TagSetDAO_HI() {
		super();
	}

}
