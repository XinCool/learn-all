package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AuditLogEntity_HI Entity Object
 * Fri Mar 27 15:41:15 CST 2020  Auto Generate
 */
@Entity
@Table(name="audit_log")
public class AuditLogEntity_HI implements Serializable{
    private String id;
    private String tenantId;
    private String customerId;
    private String entityId;
    private String entityType;
    private String entityName;
    private String userId;
    private String userName;
    private String actionType;
    private String actionData;
    private String actionStatus;
    private String actionFailureDetails;
    private Long operatorUserId;

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name="id", nullable=false, length=31)
	@GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
	@GeneratedValue(generator = "idGenerator")
	public String getId() {
		return id;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Column(name="tenant_id", nullable=true, length=31)	
	public String getTenantId() {
		return tenantId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name="customer_id", nullable=true, length=31)	
	public String getCustomerId() {
		return customerId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	@Column(name="entity_id", nullable=true, length=31)	
	public String getEntityId() {
		return entityId;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	@Column(name="entity_type", nullable=true, length=255)	
	public String getEntityType() {
		return entityType;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Column(name="entity_name", nullable=true, length=255)	
	public String getEntityName() {
		return entityName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name="user_id", nullable=true, length=31)	
	public String getUserId() {
		return userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="user_name", nullable=true, length=255)	
	public String getUserName() {
		return userName;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	@Column(name="action_type", nullable=true, length=255)	
	public String getActionType() {
		return actionType;
	}

	public void setActionData(String actionData) {
		this.actionData = actionData;
	}

	@Column(name="action_data", nullable=true, length=0)	
	public String getActionData() {
		return actionData;
	}

	public void setActionStatus(String actionStatus) {
		this.actionStatus = actionStatus;
	}

	@Column(name="action_status", nullable=true, length=255)	
	public String getActionStatus() {
		return actionStatus;
	}

	public void setActionFailureDetails(String actionFailureDetails) {
		this.actionFailureDetails = actionFailureDetails;
	}

	@Column(name="action_failure_details", nullable=true, length=0)	
	public String getActionFailureDetails() {
		return actionFailureDetails;
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
}
