package com.example.ddd.infrastructure.entities.readonly;

import java.io.Serializable;
import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import javax.persistence.Version;
import javax.persistence.Transient;

/**
 * VersionEntity_HI_RO Entity Object
 * Tue May 12 11:14:59 CST 2020  Auto Generate
 */

public class VersionEntity_HI_RO implements Serializable {
    private Long id;
    private String version;
    private String description;
    private String fileAddress;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建日期
    private Long createdBy; //创建人
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录ID
    private Integer versionNum; //版本号
    private Integer deleteFlag; //删除标识 0表示未删除 1表示删除了
    private Long operatorUserId;
	private String tenantId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * 所属厂商
	 */
	private String manufacturer;

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
	public String getVersion() {
		return version;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getDescription() {
		return description;
	}

	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}

	
	public String getFileAddress() {
		return fileAddress;
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

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	
	public Long getOperatorUserId() {
		return operatorUserId;
	}
}
