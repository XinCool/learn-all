package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.AlarmsRuleEntity_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("alarmsRuleDAO_HI_RO")
@Slf4j
public class AlarmsRuleDAO_HI_RO extends DynamicViewObjectImpl<AlarmsRuleEntity_HI_RO>  {

	public AlarmsRuleDAO_HI_RO() {
		super();
	}

}
