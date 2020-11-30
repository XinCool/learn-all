package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.DeviceWithKvAndParentId_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("deviceWithKvParentIdDAO_HI_RO")
@Slf4j
public class DeviceWithKvAndParentIdDAO_HI_RO extends DynamicViewObjectImpl<DeviceWithKvAndParentId_HI_RO> {
    public DeviceWithKvAndParentIdDAO_HI_RO() {
        super();
    }

}
