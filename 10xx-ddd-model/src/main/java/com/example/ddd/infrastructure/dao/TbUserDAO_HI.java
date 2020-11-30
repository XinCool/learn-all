package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.TbUserEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("tbUserDAO_HI")
public class TbUserDAO_HI extends BaseCommonDAO_HI<TbUserEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(TbUserDAO_HI.class);

	public TbUserDAO_HI() {
		super();
	}

}
