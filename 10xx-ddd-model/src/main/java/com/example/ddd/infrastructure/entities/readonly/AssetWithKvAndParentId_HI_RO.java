package com.example.ddd.infrastructure.entities.readonly;

import com.sie.iot.platform.asset.model.utils.enums.EntityType;
import com.sie.iot.platform.asset.model.utils.enums.RelationType;
import com.sie.iot.platform.asset.model.utils.enums.RelationTypeGroup;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class AssetWithKvAndParentId_HI_RO implements Serializable {
    public static final String QUERY_ALL_SQL = " SELECT\n" +
            "\ta.id id,\n" +
            "\ta.additional_info assetAdditionalInfo,\n" +
            "\ta.customer_id customerId,\n" +
            "\ta.`name` `name`,\n" +
            "\ta.search_text searchText,\n" +
            "\ta.tenant_id tenantId,\n" +
            "\ta.type type,\n" +
            "\tkv.entity_type entityType,\n" +
            "\tkv.entity_id entityId,\n" +
            "\tkv.attribute_name attributeName,\n"+
            "\tkv.attribute_key attributeKey,\n"+
            "\tkv.attribute_type attributeType,\n"+
            "\tkv.bool_v boolV,\n"+
            "\tkv.dbl_v dblV,\n"+
            "\tkv.long_v longV,\n"+
            "\tkv.str_v strV,\n"+
            "\tkv.id attributeId,\n"+
            "\tkv.last_update_ts lastUpdateTs,\n"+
            "\tr.to_id toId,\n"+
            "\tr.to_type toType,\n"+
            "\tr.from_id fromId,\n"+
            "\tr.from_type fromType,\n"+
            "\tr.relation_type_group relationTypeGroup,\n"+
            "\tr.relation_type relationType\n"+
            "FROM\n" +
            "\tasset AS a\n" +
            "\tLEFT JOIN attribute_kv AS kv ON kv.entity_id = a.id \n" +
            "\tAND kv.entity_type = '" + EntityType.ASSET.name() + "' \n"+
            "\tLEFT JOIN relation AS r ON r.to_id = a.id \n" +
            "\tAND r.from_type = '" + EntityType.ASSET.name() + "' \n" +
            "\tAND r.to_type = '" + EntityType.ASSET.name() + "' \n" +
            "\tAND r.relation_type_group = '" + RelationTypeGroup.COMMON.name() + "' \n" +
            "\tAND r.relation_type = '" + RelationType.Contains.name() + "' \n"+
            "\t where 1=1\n";

    public static final String QUERY_SQL = " SELECT\n" +
            "\ta.id id,\n" +
            "\ta.additional_info assetAdditionalInfo,\n" +
            "\ta.customer_id customerId,\n" +
            "\ta.`name` `name`,\n" +
            "\ta.search_text searchText,\n" +
            "\ta.tenant_id tenantId,\n" +
            "\ta.type type,\n" +
            "\tr.to_id toId,\n"+
            "\tr.to_type toType,\n"+
            "\tr.from_id fromId,\n"+
            "\tr.from_type fromType,\n"+
            "\tr.relation_type_group relationTypeGroup,\n"+
            "\tr.relation_type relationType\n"+
            "FROM\n" +
            "\tasset AS a\n" +
            "\tLEFT JOIN attribute_kv AS kv ON kv.entity_id = a.id \n" +
            "\tAND kv.entity_type = '" + EntityType.ASSET.name() + "' \n"+
            "\tLEFT JOIN relation AS r ON r.to_id = a.id and r.delete_flag=0 \n" +
            "\tAND r.from_type = '" + EntityType.ASSET.name() + "' \n" +
            "\tAND r.to_type = '" + EntityType.ASSET.name() + "' \n" +
            "\tAND r.relation_type_group = '" + RelationTypeGroup.COMMON.name() + "' \n" +
            "\tAND r.relation_type = '" + RelationType.Contains.name() + "' \n"+
            "\t where 1=1   and  a.delete_flag=0 \n";
    public static void main(String[] args) {
        System.out.println(AssetWithKvAndParentId_HI_RO.QUERY_SQL);
    }

    private String id;
    private String fromId;
    private String assetAdditionalInfo;
    private String customerId;
    private String name;
    private String searchText;
    private String tenantId;
    private String type;

    private String fromType;
    private String toId;
    private String toType;
    private String relationTypeGroup;
    private String relationType;
    private String relationAdditionalInfo;

    public List<AttributeOnlyKv_HI_RO> attributes;

}
