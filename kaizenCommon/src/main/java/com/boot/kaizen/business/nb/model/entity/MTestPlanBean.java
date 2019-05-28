package com.boot.kaizen.business.nb.model.entity;

import java.io.Serializable;

/**
 * 
 * @author weichengz
 * @date 2019年4月24日 下午2:32:59
 */
public class MTestPlanBean implements Serializable {

	private static final long serialVersionUID = 1L;
	/* 计划ID */private String planId;
	/* 测试地址 */private String testAddress;
	/* 测试人 */private String testUser;
	/* 测试时间 */private String testDate;

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getTestAddress() {
		return testAddress;
	}

	public void setTestAddress(String testAddress) {
		this.testAddress = testAddress;
	}

	public String getTestUser() {
		return testUser;
	}

	public void setTestUser(String testUser) {
		this.testUser = testUser;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public MTestPlanBean(String planId, String testAddress, String testUser, String testDate) {
		super();
		this.planId = planId;
		this.testAddress = testAddress;
		this.testUser = testUser;
		this.testDate = testDate;
	}

	public MTestPlanBean() {
		super();
	}

	public MTestPlanBean(String testDate) {
		this.testDate = testDate;
	}

}
