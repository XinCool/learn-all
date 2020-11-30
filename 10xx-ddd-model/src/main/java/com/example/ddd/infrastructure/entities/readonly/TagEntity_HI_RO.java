package com.example.ddd.infrastructure.entities.readonly;

import java.io.Serializable;
import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import javax.persistence.Version;
import javax.persistence.Transient;

/**
 * TagEntity_HI_RO Entity Object
 * Wed May 13 10:49:51 CST 2020  Auto Generate
 */

public class TagEntity_HI_RO implements Serializable {

	 public   static final  String QUERY_SQL="SELECT " +
			 "t.id as id , t. NAME as name , t.tagset_id  as tagsetId , s.tag_name as tagsetName , t.description as description , t.tenant_id as tenantId , t.version_num  as versionNum" +
			 " FROM tag t LEFT JOIN (select * from tag_set where delete_flag=0) s ON t.tagset_id = s.id where 1=1  and t.delete_flag=0  ";


    private Long id; //主键
    private String name; //标签集名称
    private Long tagsetId; //所属标签集
	private String tagsetName;  //所属标签集中午名称
    private String description; //描述
    private String tenantId; //租户id
    private Date creationDate; //创建时间
    private Long lastUpdatedBy; //更新人
    private Long lastUpdateLogin; //最后登录id
    private Integer versionNum; //版本号
    private Long operatorUserId;

	public String getTagsetName() {
		return tagsetName;
	}

	public void setTagsetName(String tagsetName) {
		this.tagsetName = tagsetName;
	}

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

	public void setTagsetId(Long tagsetId) {
		this.tagsetId = tagsetId;
	}

	
	public Long getTagsetId() {
		return tagsetId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getDescription() {
		return description;
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
