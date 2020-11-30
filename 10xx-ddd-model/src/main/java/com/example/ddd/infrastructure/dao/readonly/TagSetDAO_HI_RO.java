package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.TagSetEntity_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("tagSetDAO_HI_RO")
public class TagSetDAO_HI_RO extends DynamicViewObjectImpl<TagSetEntity_HI_RO>  {
	private static final Logger LOGGER = LoggerFactory.getLogger(TagSetDAO_HI_RO.class);
	public TagSetDAO_HI_RO() {
		super();
	}

}
