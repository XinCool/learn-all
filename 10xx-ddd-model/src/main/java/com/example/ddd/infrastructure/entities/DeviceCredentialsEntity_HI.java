package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * DeviceCredentialsEntity_HI Entity Object
 * Fri Mar 27 15:41:17 CST 2020  Auto Generate
 */
@Entity
@Table(name="device_credentials")
public class DeviceCredentialsEntity_HI implements Serializable{
    private String id;
    private String credentialsId;
	private String credentialsPassword;
    private String credentialsType;
    private String credentialsValue;
    private String deviceId;
    private Long operatorUserId;



	private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了



	public void setId(String id) {
		this.id = id;
	}

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
	@GeneratedValue(generator = "idGenerator")
	@Column(name="id", nullable=false, length=31)
	public String getId() {
		return id;
	}

	public void setCredentialsId(String credentialsId) {
		this.credentialsId = credentialsId;
	}

	@Column(name="credentials_id", nullable=true, length=0)	
	public String getCredentialsId() {
		return credentialsId;
	}


	public void setCredentialsPassword(String credentialsPassword) {
		this.credentialsPassword = credentialsPassword;
	}

	@Column(name="credentials_password", nullable=true, length=0)
	public String getCredentialsPassword() {
		return credentialsPassword;
	}

	public void setCredentialsType(String credentialsType) {
		this.credentialsType = credentialsType;
	}

	@Column(name="credentials_type", nullable=true, length=255)	
	public String getCredentialsType() {
		return credentialsType;
	}

	public void setCredentialsValue(String credentialsValue) {
		this.credentialsValue = credentialsValue;
	}

	@Column(name="credentials_value", nullable=true, length=0)	
	public String getCredentialsValue() {
		return credentialsValue;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name="device_id", nullable=true, length=31)	
	public String getDeviceId() {
		return deviceId;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	@Transient	
	public Long getOperatorUserId() {
		return operatorUserId;
	}

	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date creationDate; //创建日期
	private Long createdBy; //创建人
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateDate; //更新日期
	private Long lastUpdatedBy; //更新人
	private Long lastUpdateLogin; //最后登录ID
	private Integer versionNum; //版本号

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
	@Column(name="version_num", nullable=false, length=11)
	public Integer getVersionNum() {
		return versionNum;
	}
	@Column(name="delete_flag", nullable=true, length=11)
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
