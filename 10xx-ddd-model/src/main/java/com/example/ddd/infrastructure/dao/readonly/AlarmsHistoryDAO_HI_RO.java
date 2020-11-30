package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.AlarmsHistoryEntity_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("alarmsHistoryDAO_HI_RO")
@Slf4j
public class AlarmsHistoryDAO_HI_RO extends DynamicViewObjectImpl<AlarmsHistoryEntity_HI_RO>  {
	public AlarmsHistoryDAO_HI_RO() {
		super();
	}

}
