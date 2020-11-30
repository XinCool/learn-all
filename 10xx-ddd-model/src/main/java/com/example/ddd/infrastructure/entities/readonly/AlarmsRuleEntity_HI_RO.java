package com.example.ddd.infrastructure.entities.readonly;

import java.io.Serializable;
import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import javax.persistence.Version;
import javax.persistence.Transient;

/**
 * AlarmsRuleEntity_HI_RO Entity Object
 * Tue May 26 10:30:39 CST 2020  Auto Generate
 */

public class AlarmsRuleEntity_HI_RO implements Serializable {

	public final  static  String ALARMS_TOTAL="select count(r.rule_name) as alarmTotal\n" +
			",rule_name from alarms_rule r , alarms_history  h \n" +
			" where r.id= h.alarms_id  and  r.delete_flag=0  \n";
    private Long id; //主键
    private String ruleName; //规则名称
    private String ruleLevel; //预警级别
    private Double maxValue; //预警最大值
    private Double minValue; //预警最小值
    private Byte ruleCondition; //预警条件 0：大与 1：小或
    private String tenantId; //租户id
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date creationDate; //创建时间
    private Long createdBy;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate; //更新日期
    private Long lastUpdatedBy;
    private Long lastUpdateLogin; //最后登录id
    private Integer versionNum; //版本号

	public Integer getAlarmTotal() {
		return alarmTotal;
	}

	public void setAlarmTotal(Integer alarmTotal) {
		this.alarmTotal = alarmTotal;
	}

	private Integer alarmTotal;


	public Long getPush() {
		return push;
	}

	public void setPush(Long push) {
		this.push = push;
	}


	private Long push; //推送  0:短信 1:邮件 2: app
    private Long operatorUserId;
	private String ruleKey; //作为条件判断

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public String getRuleKey() {
		return ruleKey;
	}

	public void setRuleKey(String ruleKey) {
		this.ruleKey = ruleKey;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	
	public String getRuleName() {
		return ruleName;
	}

	public void setRuleLevel(String ruleLevel) {
		this.ruleLevel = ruleLevel;
	}

	
	public String getRuleLevel() {
		return ruleLevel;
	}



	public void setRuleCondition(Byte ruleCondition) {
		this.ruleCondition = ruleCondition;
	}

	
	public Byte getRuleCondition() {
		return ruleCondition;
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
