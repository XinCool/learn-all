package com.example.ddd.infrastructure.dao.readonly;

import com.example.ddd.infrastructure.entities.readonly.AssetWithKvAndParentId_HI_RO;
import com.siefw.hibernate.core.dao.DynamicViewObjectImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("assetWithKvParentIdDAO_HI_RO")
@Slf4j
public class AssetWithKvParentIdDAO_HI_RO extends DynamicViewObjectImpl<AssetWithKvAndParentId_HI_RO>  {
    public AssetWithKvParentIdDAO_HI_RO() {
        super();
    }

}
