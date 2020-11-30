package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * IndexKeyEntity_HI Entity Object
 * Fri Mar 27 15:41:26 CST 2020  Auto Generate
 */
@Entity
@Table(name="index_key")
public class IndexKeyEntity_HI implements Serializable{
    private String id;
    private String name;
    private String value;
    private Integer thresholdType;
    private Byte needShowed;
    private String scope;
    private String description;
    private String formula;
    private String expl;
    private Long operatorUserId;

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="id", nullable=false, length=31)
	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
//	@GenericGenerator(name = "idGenerator", strategy = "com.sie.iot.platform.asset.model.utils.id.CustomUUIDGenerator")
//	@GeneratedValue(generator = "idGenerator")
	@Column(name="name", nullable=false, length=64)
	public String getName() {
		return name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name="value", nullable=true, length=128)	
	public String getValue() {
		return value;
	}

	public void setThresholdType(Integer thresholdType) {
		this.thresholdType = thresholdType;
	}

	@Column(name="threshold_type", nullable=true, length=11)	
	public Integer getThresholdType() {
		return thresholdType;
	}

	public void setNeedShowed(Byte needShowed) {
		this.needShowed = needShowed;
	}

	@Column(name="need_showed", nullable=true, length=1)	
	public Byte getNeedShowed() {
		return needShowed;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Column(name="scope", nullable=true, length=32)	
	public String getScope() {
		return scope;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="description", nullable=true, length=1024)	
	public String getDescription() {
		return description;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Column(name="formula", nullable=true, length=1024)	
	public String getFormula() {
		return formula;
	}

	public void setExpl(String expl) {
		this.expl = expl;
	}

	@Column(name="expl", nullable=true, length=1024)	
	public String getExpl() {
		return expl;
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
