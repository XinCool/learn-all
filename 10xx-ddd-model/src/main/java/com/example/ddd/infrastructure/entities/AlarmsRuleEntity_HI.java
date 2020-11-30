package com.example.ddd.infrastructure.entities;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * AlarmsRuleEntity_HI Entity Object
 * Wed May 27 15:42:26 CST 2020  Auto Generate
 */
@Entity
@Table(name="alarms_rule")
public class AlarmsRuleEntity_HI implements Serializable{
    private Long id; //主键
    private String ruleName; //规则名称
    private String ruleLevel; //预警级别
    private Double maxValue; //预警最大值
    private Double minValue; //预警最小值
    private Byte ruleCondition; //预警条件 0：大与 1：小或  2：等于
    private String tenantId; //租户id
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建时间
    private Long createdBy;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy;
    private Long lastUpdateLogin; //最后登录id
    private Integer versionNum; //版本号
    private String ruleKey; //作为条件判断
	private Integer deleteFlag = 0; //删除标识 0表示未删除 1表示删除了



	private String  assetType;
	/**
	 * 接收人
	 */
	private String receiver;
    private Long push; //推送  0:短信 1:邮件 2: app
    private Long operatorUserId;

	public void setId(Long id) {
		this.id = id;
	}
     @Column(name = "receiver",nullable = true,length = 50)
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Id
	@GenericGenerator(name = "idGenerator", strategy = "com.example.ddd.infrastructure.utils.id.CustomUUIDGenerator")
	@GeneratedValue(generator = "redisGenerationId")
	@Column(name="id", nullable=false, length=11)	
	public Long getId() {
		return id;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	@Column(name="rule_name", nullable=true, length=50)	
	public String getRuleName() {
		return ruleName;
	}

	public void setRuleLevel(String ruleLevel) {
		this.ruleLevel = ruleLevel;
	}

	@Column(name="rule_level", nullable=true, length=50)	
	public String getRuleLevel() {
		return ruleLevel;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}


	@Column(name="max_value", nullable=true, length=16)	
	public Double getMaxValue() {
		return maxValue;
	}
	@Column(name="min_value", nullable=true, length=16)
	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public void setRuleCondition(Byte ruleCondition) {
		this.ruleCondition = ruleCondition;
	}

	@Column(name="rule_condition", nullable=true, length=1)	
	public Byte getRuleCondition() {
		return ruleCondition;
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

	@Column(name="created_by", nullable=true, length=11)	
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

	@Column(name="last_updated_by", nullable=true, length=11)	
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdateLogin(Long lastUpdateLogin) {
		this.lastUpdateLogin = lastUpdateLogin;
	}

	@Column(name="last_update_login", nullable=true, length=11)	
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

	public void setRuleKey(String ruleKey) {
		this.ruleKey = ruleKey;
	}

	@Column(name="rule_key", nullable=true, length=50)	
	public String getRuleKey() {
		return ruleKey;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Column(name="delete_flag", nullable=true, length=11)
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setPush(Long push) {
		this.push = push;
	}

	@Column(name="push", nullable=true, length=11)	
	public Long getPush() {
		return push;
	}
    @Column(nullable = true,name = "asset_type",length = 255)
	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public void setOperatorUserId(Long operatorUserId) {
		this.operatorUserId = operatorUserId;
	}

	@Transient	
	public Long getOperatorUserId() {
		return operatorUserId;
	}
}
