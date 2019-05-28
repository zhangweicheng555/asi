package com.boot.kaizen.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 流程与业务表的关系 business_activiti_check_result
 * 
 * @author weichengz
 * @date 2018年11月4日 下午12:04:32
 */
public class BusinessActivitiRelation implements Serializable {

	private static final long serialVersionUID = 6180869216498363919L;

	private Long id;// 主键ID 自增
	private String checkResult; // 节点的审核结果
	private String bussType; // 记录的业务类型 类名
	private Date createTime; // 创建时间
	private Long bussId; // 记录的id
	private String checkPersionId; // 审核人 不一定时最终的
	private Long projId; // 项目的id
	private String actTaskName; // 执行节点得到名字
	private String actTaskKey; // 执行节点的id
	private String actPiid; // 流程实力的id

	public BusinessActivitiRelation(String bussType, Date createTime, Long bussId, Long projId, String actPiid) {
		super();
		this.bussType = bussType;
		this.createTime = createTime;
		this.bussId = bussId;
		this.projId = projId;
		this.actPiid = actPiid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getBussId() {
		return bussId;
	}

	public void setBussId(Long bussId) {
		this.bussId = bussId;
	}

	public String getCheckPersionId() {
		return checkPersionId;
	}

	public void setCheckPersionId(String checkPersionId) {
		this.checkPersionId = checkPersionId;
	}

	public Long getProjId() {
		return projId;
	}

	public void setProjId(Long projId) {
		this.projId = projId;
	}

	public String getActTaskName() {
		return actTaskName;
	}

	public void setActTaskName(String actTaskName) {
		this.actTaskName = actTaskName;
	}

	public String getActTaskKey() {
		return actTaskKey;
	}

	public void setActTaskKey(String actTaskKey) {
		this.actTaskKey = actTaskKey;
	}

	public String getActPiid() {
		return actPiid;
	}

	public void setActPiid(String actPiid) {
		this.actPiid = actPiid;
	}

	public BusinessActivitiRelation(Long id, String checkResult, String bussType, Date createTime, Long bussId,
			String checkPersionId, Long projId, String actTaskName, String actTaskKey, String actPiid) {
		super();
		this.id = id;
		this.checkResult = checkResult;
		this.bussType = bussType;
		this.createTime = createTime;
		this.bussId = bussId;
		this.checkPersionId = checkPersionId;
		this.projId = projId;
		this.actTaskName = actTaskName;
		this.actTaskKey = actTaskKey;
		this.actPiid = actPiid;
	}

	public BusinessActivitiRelation() {
		super();
	}

}
