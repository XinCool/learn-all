package com.example.ddd.infrastructure.entities.readonly;

import lombok.Data;
import com.example.ddd.infrastructure.utils.enums.EntityType;
import com.example.ddd.infrastructure.utils.enums.RelationType;
import com.example.ddd.infrastructure.utils.enums.RelationTypeGroup;

import java.io.Serializable;
import java.util.List;

@Data
public class DeviceWithKvAndParentId_HI_RO implements Serializable {
    public static final String QUERY_SQL = " SELECT\n" +
            "\td.id id,\n" +
            "\td.additional_info additionalInfo,\n" +
            "\td.customer_id customerId,\n" +
            "\td.`name` `name`,\n" +
            "\td.search_text searchText,\n" +
            "\td.tenant_id tenantId,\n" +
            "\td.type type,\n" +
            "\td.device_type_id deviceTypeId,\n" +
            "\tr.to_type toType,\n" +
            "\tr.from_id fromId,\n" +
            "\tr.from_type fromType,\n" +
            "\tr.relation_type_group relationTypeGroup,\n" +
            "\tr.relation_type relationType\n" +
            "FROM\n" +
            "\tdevice AS d\n" +
            "\tLEFT JOIN attribute_kv AS kv ON kv.entity_id = d.id  and kv.delete_flag=0 \n" +
            "\tAND kv.entity_type = '" + EntityType.DEVICE.name() + "' \n" +
            "\tLEFT JOIN relation AS r ON r.delete_flag=0 AND d.id = r.to_id\n" +
            "\tAND r.to_type = '" + EntityType.DEVICE.name() + "' \n" +
            /*"\tAND r.relation_type_group = '" + RelationTypeGroup.COMMON.name() + "' \n" +
            "\tAND r.from_type = '" + EntityType.DEVICE.name() + "' \n" +
            "\tAND r.relation_type = '" + RelationType.Contains.name() + "' \n"+*/
            "\t where d.delete_flag = 0 \n";

    public static void main(String[] args) {
        System.out.println(QUERY_SQL);
    }

    private String id;
    private String fromId;
    private String additionalInfo;
    private String customerId;
    private String name;
    private String searchText;
    private String tenantId;
    private String type;
    private Integer deviceTypeId;


    private String fromType;
    private String toType;
    private String relationTypeGroup;
    private String relationType;
    private String relationAdditionalInfo;
    private List<AttributeOnlyKv_HI_RO> attributes;
}
