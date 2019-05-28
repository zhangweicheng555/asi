package com.boot.kaizen.business.nb.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 小区模型
 * 
 * @author weichengz
 * @date 2019年4月24日 下午1:55:33
 */
public class CommunityBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/* 小区名字 */private String mCommunityBeanName;
	/* 小区工程 */private MCommunityProjectBean mCommunityProject;
	/* 小区网优 */private MCommunityNetworkOptimizationBean mCommunityNetworkOptimization;
	/* 小区测试项 */private List<String> mCommunityTestItemList = new ArrayList<String>();

	public String getmCommunityBeanName() {
		return mCommunityBeanName;
	}

	public void setmCommunityBeanName(String mCommunityBeanName) {
		this.mCommunityBeanName = mCommunityBeanName;
	}

	public MCommunityProjectBean getmCommunityProject() {
		return mCommunityProject;
	}

	public void setmCommunityProject(MCommunityProjectBean mCommunityProject) {
		this.mCommunityProject = mCommunityProject;
	}

	public MCommunityNetworkOptimizationBean getmCommunityNetworkOptimization() {
		return mCommunityNetworkOptimization;
	}

	public void setmCommunityNetworkOptimization(MCommunityNetworkOptimizationBean mCommunityNetworkOptimization) {
		this.mCommunityNetworkOptimization = mCommunityNetworkOptimization;
	}

	public List<String> getmCommunityTestItemList() {
		return mCommunityTestItemList;
	}

	public void setmCommunityTestItemList(List<String> mCommunityTestItemList) {
		this.mCommunityTestItemList = mCommunityTestItemList;
	}

	public CommunityBean(String mCommunityBeanName, MCommunityProjectBean mCommunityProject,
			MCommunityNetworkOptimizationBean mCommunityNetworkOptimization, List<String> mCommunityTestItemList) {
		super();
		this.mCommunityBeanName = mCommunityBeanName;
		this.mCommunityProject = mCommunityProject;
		this.mCommunityNetworkOptimization = mCommunityNetworkOptimization;
		this.mCommunityTestItemList = mCommunityTestItemList;
	}

	public CommunityBean() {
		super();
	}

}
