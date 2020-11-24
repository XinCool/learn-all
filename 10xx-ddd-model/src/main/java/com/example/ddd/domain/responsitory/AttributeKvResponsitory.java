package com.example.ddd.domain.responsitory;


import com.example.ddd.domain.entities.AttributeKvEntity_HI;
import com.example.ddd.domain.entities.readonly.AttributeOnlyKv_HI_RO;
import com.example.ddd.domain.responsitory.inter.IAttributeKvResponsitory;
import com.siefw.hibernate.core.dao.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Cool
 * @create 2020-11-16 17:15
 */
@Component("attributeKvResponsitory")
public class AttributeKvResponsitory implements IAttributeKvResponsitory {
    @Autowired
    private ViewObject<AttributeKvEntity_HI> attributeKvDAO_HI;

    /**
     * 根据设备id查询其所有的属性
     * @param deviceId
     * @return
     */
    @Override
    public List<AttributeKvEntity_HI> findByDeviceId(String deviceId) {
        String sql = AttributeOnlyKv_HI_RO.QUERY_SQL+" and kv.entity_type='DEVICE' and kv.entityId='"+deviceId+"'";
        List<AttributeKvEntity_HI> attributeKvEntity_HIs = attributeKvDAO_HI.findList(sql, new Object[]{});
        return attributeKvEntity_HIs;
    }


}
