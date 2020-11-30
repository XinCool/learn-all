package com.example.ddd.infrastructure.entities.readonly;

import com.sie.iot.platform.asset.model.utils.enums.EntityType;
import com.sie.iot.platform.asset.model.utils.enums.RelationType;
import com.sie.iot.platform.asset.model.utils.enums.RelationTypeGroup;
import com.sie.iot.platform.asset.model.utils.id.UUIDConverter;

import java.io.Serializable;

public class RedisDeviceInfo_RO implements Serializable {

    private static final long serialVersionUID = -5168138870085352465L;

    public static final String QUERY_SQL = "SELECT d.id,d.name,d.type,d.tenant_id,to_id as device_type_id,dc.credentials_id,dc.credentials_password FROM device d\n"
                                            +"\tLEFT JOIN relation r ON r.from_id = d.id    and r.delete_flag=0  AND r.to_type ='" + EntityType.DEVICE_SUPPLIER_TYPE.name() +"'\n"
                                            +"\tLEFT JOIN device_credentials dc ON dc.device_id = d.id where d.delete_flag=0  \n";

    private String id;

    private String uuid;

    private String name;

    private String type;

    private String deviceTypeId;

    private String credentialsId;

    private String credentialsPassword;

    private String tenantId;

    private String tenantUuid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return UUIDConverter.fromString(this.id).toString();
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(String credentialsId) {
        this.credentialsId = credentialsId;
    }

    public String getCredentialsPassword() {
        return credentialsPassword;
    }

    public void setCredentialsPassword(String credentialsPassword) {
        this.credentialsPassword = credentialsPassword;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantUuid() {
        return UUIDConverter.fromString(this.tenantId).toString();
    }

    public void setTenantUuid(String tenantUuid) {
        this.tenantUuid = tenantUuid;
    }
}
