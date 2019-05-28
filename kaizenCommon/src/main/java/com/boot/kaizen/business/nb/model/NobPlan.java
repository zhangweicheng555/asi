package com.boot.kaizen.business.nb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 规划表
 * 
 * @author weichengz
 * @date 2019年4月23日 上午9:14:08
 */
public class NobPlan implements Serializable {

	private static final long serialVersionUID = 320883452002869837L;

	private String planeid;// 主键 自动生成
	
	private String nodebid;// 基站号
	private String jzname;// 基站名称
	private String userid;// 系统登录的账号
	private String plantestengineer;// 测试工程师
	private String plantestphone;// 工程师电话
	private String planbackendengineer;// 后台工程师
	private String planbackendphone;// 后台工程师电话
	private String planetesttime;// 测试时间
	
	
	private String planetestcontent;// 测试任务内容
	private String planetestid;// 测试任务配置表id
	

	private String checkresult;// 核查结果 1代表上传 其他代表没上传 下面同理
	private String testresult;// 测试结果 1代表上传 其他代表没上传 下面同理
	private String docresult;// 单验报告 1代表上传 其他代表没上传 下面同理

	// common
	private Integer projId;
	private Date createTime;

	public String getPlaneid() {
		return planeid;
	}

	public void setPlaneid(String planeid) {
		this.planeid = planeid;
	}

	public String getNodebid() {
		return nodebid;
	}

	public void setNodebid(String nodebid) {
		this.nodebid = nodebid;
	}



	public String getJzname() {
		return jzname;
	}

	public void setJzname(String jzname) {
		this.jzname = jzname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPlantestengineer() {
		return plantestengineer;
	}

	public void setPlantestengineer(String plantestengineer) {
		this.plantestengineer = plantestengineer;
	}

	public String getPlantestphone() {
		return plantestphone;
	}

	public void setPlantestphone(String plantestphone) {
		this.plantestphone = plantestphone;
	}

	public String getPlanbackendengineer() {
		return planbackendengineer;
	}

	public void setPlanbackendengineer(String planbackendengineer) {
		this.planbackendengineer = planbackendengineer;
	}

	public String getPlanbackendphone() {
		return planbackendphone;
	}

	public void setPlanbackendphone(String planbackendphone) {
		this.planbackendphone = planbackendphone;
	}

	public String getPlanetesttime() {
		return planetesttime;
	}

	public void setPlanetesttime(String planetesttime) {
		this.planetesttime = planetesttime;
	}

	public String getPlanetestid() {
		return planetestid;
	}

	public void setPlanetestid(String planetestid) {
		this.planetestid = planetestid;
	}

	public String getPlanetestcontent() {
		return planetestcontent;
	}

	public void setPlanetestcontent(String planetestcontent) {
		this.planetestcontent = planetestcontent;
	}

	public String getCheckresult() {
		return checkresult;
	}

	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
	}

	public String getTestresult() {
		return testresult;
	}

	public void setTestresult(String testresult) {
		this.testresult = testresult;
	}

	public String getDocresult() {
		return docresult;
	}

	public void setDocresult(String docresult) {
		this.docresult = docresult;
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

	public NobPlan(String planeid, String nodebid, String jzname, String userid, String plantestengineer,
			String plantestphone, String planbackendengineer, String planbackendphone, String planetesttime,
			String planetestid, String planetestcontent, String checkresult, String testresult, String docresult,
			Integer projId, Date createTime) {
		super();
		this.planeid = planeid;
		this.nodebid = nodebid;
		this.jzname = jzname;
		this.userid = userid;
		this.plantestengineer = plantestengineer;
		this.plantestphone = plantestphone;
		this.planbackendengineer = planbackendengineer;
		this.planbackendphone = planbackendphone;
		this.planetesttime = planetesttime;
		this.planetestid = planetestid;
		this.planetestcontent = planetestcontent;
		this.checkresult = checkresult;
		this.testresult = testresult;
		this.docresult = docresult;
		this.projId = projId;
		this.createTime = createTime;
	}

	public NobPlan() {
	}

}
