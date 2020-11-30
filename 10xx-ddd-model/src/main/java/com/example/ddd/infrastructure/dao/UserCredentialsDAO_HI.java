package com.example.ddd.infrastructure.dao;

import com.example.ddd.infrastructure.entities.UserCredentialsEntity_HI;
import com.sie.iot.common.model.dao.BaseCommonDAO_HI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("userCredentialsDAO_HI")
public class UserCredentialsDAO_HI extends BaseCommonDAO_HI<UserCredentialsEntity_HI> {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserCredentialsDAO_HI.class);

	public UserCredentialsDAO_HI() {
		super();
	}

}
