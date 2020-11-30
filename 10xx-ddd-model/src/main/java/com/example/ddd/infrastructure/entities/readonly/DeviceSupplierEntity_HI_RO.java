package com.example.ddd.infrastructure.entities.readonly;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * DeviceSupplierEntity_HI_RO Entity Object
 * Fri Jul 17 14:57:21 CST 2020  Auto Generate
 */

public class DeviceSupplierEntity_HI_RO implements Serializable {
    private Long id; //主键
    private String name; //规则名称
    private String tenantId; //租户id
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建时间
    private Long createdBy;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy;
    private Long lastUpdateLogin; //最后登录id
    private Integer versionNum; //版本号
    private Long operatorUserId;

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	
	public String getTenantId() {
		return tenantId;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	
	public Long getCreatedBy() {
		return createdBy;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	
	public Long getLastUpdateLogin() {
		return lastUpdateLogin;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	
	public Integer getVersionNum() {
		return versionNum;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	
	public Long getOperatorUserId() {
		return operatorUserId;
	}
}
