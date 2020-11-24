package com.example.ddd.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import com.example.ddd.domain.device.entities.AttributeKvInfo;
import com.example.ddd.domain.device.repository.IAttributeKvRepository;
import com.example.ddd.infrastructure.dao.readonly.AttributeOnlyKvDAO_HI_RO;
import com.example.ddd.infrastructure.entities.AttributeKvEntity_HI;
import com.siefw.hibernate.core.dao.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cool
 * @create 2020-11-16
 */
@Component("attributeKvRepository")
public class AttributeKvRepository implements IAttributeKvRepository {
    @Autowired
    private ViewObject<AttributeKvEntity_HI> attributeKvDAO_HI;
    @Autowired
    private AttributeOnlyKvDAO_HI_RO attributeOnlyKvDAO_HI_RO;

    /* @Override
     public List<AttributeKv> findListByDeviceId(String deviceId) {
         String sql = AttributeOnlyKv_HI_RO.QUERY_SQL+" and kv.entity_type='DEVICE' and kv.entity_id='"+deviceId+"'";
         List<AttributeOnlyKv_HI_RO> list = attributeOnlyKvDAO_HI_RO.findList(sql + " order by kv.creation_date desc");
         List<AttributeKv> attributeKvs = new ArrayList<>();
         list.forEach(attribute -> {
             AttributeKv attributeKv = new AttributeKv();
             BeanUtil.copyProperties(attribute, attributeKv);
             attributeKvs.add(attributeKv);
         });
         return attributeKvs;
     }*/
    @Override
    public List<AttributeKvInfo> findListByDeviceId(String deviceId) {
        Map<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("entityId", deviceId);
        paramMap.put("entityType", "DEVICE");
        List<AttributeKvEntity_HI> attributeKvEntity_his = attributeKvDAO_HI.findByProperty(paramMap);
        List<AttributeKvInfo> attributeKvs = new ArrayList<>();
        if (attributeKvEntity_his != null && attributeKvEntity_his.size() != 0) {
            attributeKvEntity_his.forEach(attributeKvEntity -> {
                AttributeKvInfo attributeKvInfo = new AttributeKvInfo();
                BeanUtil.copyProperties(attributeKvEntity, attributeKvInfo);
                attributeKvs.add(attributeKvInfo);
            });

        }
        return attributeKvs;
    }
}
