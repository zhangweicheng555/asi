package com.boot.kaizen.business.nb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 参数核查
 * 
 * @author weichengz
 * @date 2019年4月23日 下午2:07:42
 */
public class NobParamcheck implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;// 主键 自动生成
	private String userId;// 用户ID
	private String testDate;// 测试时间
	private String station_No;// 基站号
	private String communityName;// 小区名(小区ID也行)
	private String cellId;// CELL ID
	private String pci;// PCI
	private String frequency;// 频点

	// common
	private Integer projId;
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getStation_No() {
		return station_No;
	}

	public void setStation_No(String station_No) {
		this.station_No = station_No;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public String getPci() {
		return pci;
	}

	public void setPci(String pci) {
		this.pci = pci;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public NobParamcheck(String id, String userId, String testDate, String station_No, String communityName,
			String cellId, String pci, String frequency, Integer projId, Date createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.testDate = testDate;
		this.station_No = station_No;
		this.communityName = communityName;
		this.cellId = cellId;
		this.pci = pci;
		this.frequency = frequency;
		this.projId = projId;
		this.createTime = createTime;
	}

	public NobParamcheck() {
		super();
	}

}
