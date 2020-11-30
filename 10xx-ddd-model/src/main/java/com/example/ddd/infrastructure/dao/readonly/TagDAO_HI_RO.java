package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.TagEntity_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("tagDAO_HI_RO")
public class TagDAO_HI_RO extends DynamicViewObjectImpl<TagEntity_HI_RO>  {
	private static final Logger LOGGER = LoggerFactory.getLogger(TagDAO_HI_RO.class);
	public TagDAO_HI_RO() {
		super();
	}

}
