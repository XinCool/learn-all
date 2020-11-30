package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AlarmEntity_HI Entity Object
 * Fri Mar 27 15:41:05 CST 2020  Auto Generate
 */
@Entity
@Table(name="alarm")
public class AlarmEntity_HI implements Serializable{
    private String id;
    private Long ackTs;
    private Long clearTs;
    private String additionalInfo;
    private Long endTs;
    private String originatorId;
    private Integer originatorType;
    private Byte propagate;
    private String severity;
    private Long startTs;
    private String status;
    private String tenantId;
    private String type;
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

	public void setAckTs(Long ackTs) {
		this.ackTs = ackTs;
	}

	@Column(name="ack_ts", nullable=true, length=20)
	public Long getAckTs() {
		return ackTs;
	}

	public void setClearTs(Long clearTs) {
		this.clearTs = clearTs;
	}

	@Column(name="clear_ts", nullable=true, length=20)
	public Long getClearTs() {
		return clearTs;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Column(name="additional_info", nullable=true, length=0)	
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setEndTs(Long endTs) {
		this.endTs = endTs;
	}

	@Column(name="end_ts", nullable=true, length=20)	
	public Long getEndTs() {
		return endTs;
	}

	public void setOriginatorId(String originatorId) {
		this.originatorId = originatorId;
	}

	@Column(name="originator_id", nullable=true, length=31)	
	public String getOriginatorId() {
		return originatorId;
	}

	public void setOriginatorType(Integer originatorType) {
		this.originatorType = originatorType;
	}

	@Column(name="originator_type", nullable=true, length=11)	
	public Integer getOriginatorType() {
		return originatorType;
	}

	public void setPropagate(Byte propagate) {
		this.propagate = propagate;
	}

	@Column(name="propagate", nullable=true, length=1)	
	public Byte getPropagate() {
		return propagate;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	@Column(name="severity", nullable=true, length=255)	
	public String getSeverity() {
		return severity;
	}

	public void setStartTs(Long startTs) {
		this.startTs = startTs;
	}

	@Column(name="start_ts", nullable=true, length=20)	
	public Long getStartTs() {
		return startTs;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="status", nullable=true, length=255)	
	public String getStatus() {
		return status;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@Column(name="tenant_id", nullable=true, length=31)	
	public String getTenantId() {
		return tenantId;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="type", nullable=true, length=255)	
	public String getType() {
		return type;
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
