package com.boot.kaizen.business.nb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 路测信息图
 * 
 * @author weichengz
 * @date 2019年4月24日 下午4:34:31
 */
public class NobRoadInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String userId;// 用户ID
	private String station_No;// 站号
	private String rtlist;// 测试数据
	private String rsrpImage;// Rsrp打点截图
	private String sinrImage;// Sinr打点截图
	private String pciImage;// Pci打点截图
	private String communityName;// 小区名
	private String picThresholdImage;// pci动态图
	
	private String sinrThresholdImage;// sinr动态图
	private String rsrpThresholdImage;// rsrp动态图

	// common
	private Integer projId;
	private Date createTime;

	
	
	public String getSinrThresholdImage() {
		return sinrThresholdImage;
	}

	public void setSinrThresholdImage(String sinrThresholdImage) {
		this.sinrThresholdImage = sinrThresholdImage;
	}

	public String getRsrpThresholdImage() {
		return rsrpThresholdImage;
	}

	public void setRsrpThresholdImage(String rsrpThresholdImage) {
		this.rsrpThresholdImage = rsrpThresholdImage;
	}

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

	public String getStation_No() {
		return station_No;
	}

	public void setStation_No(String station_No) {
		this.station_No = station_No;
	}

	public String getRtlist() {
		return rtlist;
	}

	public void setRtlist(String rtlist) {
		this.rtlist = rtlist;
	}

	public String getRsrpImage() {
		return rsrpImage;
	}

	public void setRsrpImage(String rsrpImage) {
		this.rsrpImage = rsrpImage;
	}

	public String getSinrImage() {
		return sinrImage;
	}

	public void setSinrImage(String sinrImage) {
		this.sinrImage = sinrImage;
	}

	public String getPciImage() {
		return pciImage;
	}

	public void setPciImage(String pciImage) {
		this.pciImage = pciImage;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getPicThresholdImage() {
		return picThresholdImage;
	}

	public void setPicThresholdImage(String picThresholdImage) {
		this.picThresholdImage = picThresholdImage;
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

	public NobRoadInfo() {
		super();
	}

	public NobRoadInfo(String id, String userId, String station_No, String rtlist, String rsrpImage, String sinrImage,
			String pciImage, String communityName, String picThresholdImage, Integer projId, Date createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.station_No = station_No;
		this.rtlist = rtlist;
		this.rsrpImage = rsrpImage;
		this.sinrImage = sinrImage;
		this.pciImage = pciImage;
		this.communityName = communityName;
		this.picThresholdImage = picThresholdImage;
		this.projId = projId;
		this.createTime = createTime;
	}

}
