package com.example.ddd.infrastructure.entities.readonly;

import com.sie.iot.platform.asset.model.utils.enums.EntityType;
import com.sie.iot.platform.asset.model.utils.enums.RelationType;
import com.sie.iot.platform.asset.model.utils.enums.RelationTypeGroup;
import lombok.Data;

import java.io.Serializable;
@Data
public class AssetWithDeviceId_RO implements Serializable {
    public static final String QUERY_SQL = " SELECT\n" +
            "\ta.id id,\n" +
            "\ta.additional_info additionalInfo,\n" +
            "\ta.customer_id customerId,\n" +
            "\ta.type type,\n" +
            "\ta.`name` `name`,\n" +
            "\ta.search_text searchText,\n" +
            "\ta.tenant_id tenantId,\n" +
            "\ta.creation_date,\n" +
            "\ta.created_by,\n" +
            "\ta.last_update_date,\n" +
            "\ta.last_updated_by,\n" +
            "\ta.last_update_login,\n" +
            "\ta.version_num,\n" +
            "\tr. from_id  AS DeviceId \n" +
            "FROM\n" +
            "\t asset  AS a\n" +
            "\tRIGHT JOIN relation AS r ON r.to_id = a.id  and r.delete_flag=0 \n" +
            "\tAND r.from_type = '"+ EntityType.DEVICE.name()+"' \n" +
            "\tAND r.to_type = '"+EntityType.ASSET.name() +"' \n" +
            "\tAND r.relation_type_group = '"+ RelationTypeGroup.COMMON.name() +"' \n" +
            "\tAND r.relation_type = '"+ RelationType.CollectorToAsset.name() +"' \n" +
            "WHERE\n" + "  1=1   and a.delete_flag=0";
    //"\t d.type = '"+DeviceType.collector.name() +"' \n";
//            "\tAND r.to_id IS NOT NULL ";

    public static void main(String[] args) {
        System.out.println(AssetWithDeviceId_RO.QUERY_SQL);
    }
    private String id;
    private String additionalInfo;
    private String customerId;
    private String type;
    private String name;
    private String searchText;
    private String tenantId;
    private String DeviceId;

}
