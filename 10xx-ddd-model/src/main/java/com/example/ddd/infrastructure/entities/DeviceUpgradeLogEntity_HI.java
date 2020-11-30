package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * DeviceUpgradeLogEntity_HI Entity Object
 * Thu Apr 23 10:46:43 CST 2020  Auto Generate
 */
@Entity
@Table(name="device_upgrade_log")
public class DeviceUpgradeLogEntity_HI implements Serializable{
    private Long id;
    private String upgradeStatus; //升级状态  1升级完成
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date upgradeDate; //升级时间
    private String additionalInfo; //更新说明
    private String upgradePackageUrl; //更新包路径
    private String customerId; //客户ID
    private String tenantId; //租户ID
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号
    private Long operatorUserId;

   

	public void setId(Long id) {
		this.id = id;
	}

	@Id	
	@GenericGenerator(name = "redisGenerationId", strategy = "com.sie.iot.common.idgenerate.RedisGenerationId")
	@GeneratedValue(generator = "redisGenerationId")
	@Column(name="id", nullable=false, length=20)
	public Long getId() {
		return id;
	}

	public void setUpgradeStatus(String upgradeStatus) {
		this.upgradeStatus = upgradeStatus;
	}

	@Column(name="upgrade_status", nullable=true, length=255)	
	public String getUpgradeStatus() {
		return upgradeStatus;
	}

	public void setUpgradeDate(Date upgradeDate) {
		this.upgradeDate = upgradeDate;
	}

	@Column(name="upgrade_date", nullable=true, length=0)	
	public Date getUpgradeDate() {
		return upgradeDate;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Column(name="additional_info", nullable=true, length=500)	
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setUpgradePackageUrl(String upgradePackageUrl) {
		this.upgradePackageUrl = upgradePackageUrl;
	}

	@Column(name="upgrade_package_url", nullable=true, length=256)	
	public String getUpgradePackageUrl() {
		return upgradePackageUrl;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name="customer_id", nullable=true, length=31)	
	public String getCustomerId() {
		return customerId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Column(name="tenant_id", nullable=true, length=31)	
	public String getTenantId() {
		return tenantId;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name="creation_date", nullable=true, length=0)	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="created_by", nullable=true, length=20)	
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Column(name="last_update_date", nullable=true, length=0)	
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Column(name="last_updated_by", nullable=true, length=20)	
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	@Column(name="last_update_login", nullable=true, length=20)	
	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	@Version
	@Column(name="version_num", nullable=true, length=11)	
	public Integer getVersionNum() {
		return versionNum;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	@Transient	
	public Long getOperatorUserId() {
		return operatorUserId;
	}
}
