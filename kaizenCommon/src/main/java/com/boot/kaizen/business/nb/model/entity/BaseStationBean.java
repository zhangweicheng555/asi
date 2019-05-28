package com.boot.kaizen.business.nb.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 基站模型
 * 
 * @author weichengz
 * @date 2019年4月24日 下午1:54:29
 */
public class BaseStationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/* 基站名称 */private String mBaseStationName;
	/* 基站海拔 */private String mAltitude;
	/* 纬度 */private String mLatitude;
	/* 基站类型 */private String mBaseStationType;
	/* 基站编号 */private String mBaseStationNumber;
	/* 经度 */private String mLongitude;
	/* 小区数据集 */private List<CommunityBean> mCommunityBeanList = new ArrayList<CommunityBean>();

	public String getmBaseStationName() {
		return mBaseStationName;
	}

	public void setmBaseStationName(String mBaseStationName) {
		this.mBaseStationName = mBaseStationName;
	}

	public String getmAltitude() {
		return mAltitude;
	}

	public void setmAltitude(String mAltitude) {
		this.mAltitude = mAltitude;
	}

	public String getmLatitude() {
		return mLatitude;
	}

	public void setmLatitude(String mLatitude) {
		this.mLatitude = mLatitude;
	}

	public String getmBaseStationType() {
		return mBaseStationType;
	}

	public void setmBaseStationType(String mBaseStationType) {
		this.mBaseStationType = mBaseStationType;
	}

	public String getmBaseStationNumber() {
		return mBaseStationNumber;
	}

	public void setmBaseStationNumber(String mBaseStationNumber) {
		this.mBaseStationNumber = mBaseStationNumber;
	}

	public String getmLongitude() {
		return mLongitude;
	}

	public void setmLongitude(String mLongitude) {
		this.mLongitude = mLongitude;
	}

	public List<CommunityBean> getmCommunityBeanList() {
		return mCommunityBeanList;
	}

	public void setmCommunityBeanList(List<CommunityBean> mCommunityBeanList) {
		this.mCommunityBeanList = mCommunityBeanList;
	}

	public BaseStationBean(String mBaseStationName, String mAltitude, String mLatitude, String mBaseStationType,
			String mBaseStationNumber, String mLongitude, List<CommunityBean> mCommunityBeanList) {
		super();
		this.mBaseStationName = mBaseStationName;
		this.mAltitude = mAltitude;
		this.mLatitude = mLatitude;
		this.mBaseStationType = mBaseStationType;
		this.mBaseStationNumber = mBaseStationNumber;
		this.mLongitude = mLongitude;
		this.mCommunityBeanList = mCommunityBeanList;
	}

	public BaseStationBean() {
		super();
	}

}
