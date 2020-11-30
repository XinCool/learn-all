package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.IotBasePayloadEntity_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yinzan
 */
@Component("iotBasePayloadDAO_HI_RO")
public class IotBasePayloadDAO_HI_RO extends DynamicViewObjectImpl<IotBasePayloadEntity_HI_RO> {
	private static final Logger LOGGER = LoggerFactory.getLogger(IotBasePayloadDAO_HI_RO.class);
	public IotBasePayloadDAO_HI_RO() {
		super();
	}

}
