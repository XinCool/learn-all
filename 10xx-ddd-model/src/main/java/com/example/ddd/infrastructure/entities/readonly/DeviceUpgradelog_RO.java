package com.example.ddd.infrastructure.entities.readonly;

import com.alibaba.fastjson.annotation.JSONField;
import com.sie.iot.platform.asset.model.utils.enums.EntityType;
import com.sie.iot.platform.asset.model.utils.enums.RelationType;
import com.sie.iot.platform.asset.model.utils.enums.RelationTypeGroup;
import org.springframework.stereotype.Component;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yinzan
 * @ClassName: DeviceUpgradelog_RO
 * @ProjectName sie-iot-platform-v1.0
 * @Description: TODO
 * @date 2020/4/26上午11:19
 */
public class DeviceUpgradelog_RO implements Serializable {


    public static final String QUERY_SQL = "SELECT l.id as id ,l.upgrade_status " +
            "as upgradeStatus,l.upgrade_date  as upgradeDate ,l.additional_info " +
            " as additionalInfo,l.upgrade_package_url  as  upgradePackageUrl," +
            "l.version_num as versionNum ," +
            "( SELECT GROUP_CONCAT(name) FROM device WHERE " +
            "id IN(select r.to_id from relation r where   r.from_type = '" + EntityType.UPGRADE_DEVICE.name() + "' and  r.delete_flag=0 and  r.to_type = '" + EntityType.DEVICE.name() +
            "'and r.relation_type_group = '" + RelationTypeGroup.UPGRADE.name()  +
            "' and r.relation_type = '" + RelationType.UpGradeToDevice.name() + "' and r.from_id=l.id )) AS deviceNames FROM device_upgrade_log l  where 1=1";

    private Long id;
    private String upgradeStatus; //升级状态  1升级完成
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date upgradeDate; //升级时间
    private String additionalInfo; //更新说明
    private String upgradePackageUrl; //更新包路径
    private Integer versionNum; //版本号
    private String deviceNames;

    public static String getQuerySql() {
        return QUERY_SQL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUpgradeStatus() {
        return upgradeStatus;
    }

    public void setUpgradeStatus(String upgradeStatus) {
        this.upgradeStatus = upgradeStatus;
    }

    public Date getUpgradeDate() {
        return upgradeDate;
    }

    public void setUpgradeDate(Date upgradeDate) {
        this.upgradeDate = upgradeDate;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getUpgradePackageUrl() {
        return upgradePackageUrl;
    }

    public void setUpgradePackageUrl(String upgradePackageUrl) {
        this.upgradePackageUrl = upgradePackageUrl;
    }

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public String getDeviceNames() {
        return deviceNames;
    }

    public void setDeviceNames(String deviceNames) {
        this.deviceNames = deviceNames;
    }
}
