package com.boot.kaizen.business.nb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 基站勘察
 * 
 * @author weichengz
 * @date 2019年4月23日 上午11:22:36
 */
public class NobCheck implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nodebid;// NodeB ID 整数
	private String jzname;// 基站名称
	private String cellid;// 小区 1 2 3
	private String checkperson;// 核查人
	private String checkdate;// 核查日期 yyyy-mm-dd
	private String checkcontent;// 核查内容 告警、驻波比、上行RSSI
	private String checkresult;// 核查结果 正常 不正常
	private String checkbeizhu;// 备注
	private String checkjielun;// 结论
	private String removedate;// 异常消除日期 yyyy-mm-dd

	// common
	private Integer projId;
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCellid() {
		return cellid;
	}

	public void setCellid(String cellid) {
		this.cellid = cellid;
	}

	public String getCheckperson() {
		return checkperson;
	}

	public void setCheckperson(String checkperson) {
		this.checkperson = checkperson;
	}

	public String getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}

	public String getCheckcontent() {
		return checkcontent;
	}

	public void setCheckcontent(String checkcontent) {
		this.checkcontent = checkcontent;
	}

	public String getCheckresult() {
		return checkresult;
	}

	public void setCheckresult(String checkresult) {
		this.checkresult = checkresult;
	}

	public String getCheckbeizhu() {
		return checkbeizhu;
	}

	public void setCheckbeizhu(String checkbeizhu) {
		this.checkbeizhu = checkbeizhu;
	}

	public String getCheckjielun() {
		return checkjielun;
	}

	public void setCheckjielun(String checkjielun) {
		this.checkjielun = checkjielun;
	}

	public String getRemovedate() {
		return removedate;
	}

	public void setRemovedate(String removedate) {
		this.removedate = removedate;
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

	public NobCheck(String id, String nodebid, String jzname, String cellid, String checkperson, String checkdate,
			String checkcontent, String checkresult, String checkbeizhu, String checkjielun, String removedate,
			Integer projId, Date createTime) {
		super();
		this.id = id;
		this.nodebid = nodebid;
		this.jzname = jzname;
		this.cellid = cellid;
		this.checkperson = checkperson;
		this.checkdate = checkdate;
		this.checkcontent = checkcontent;
		this.checkresult = checkresult;
		this.checkbeizhu = checkbeizhu;
		this.checkjielun = checkjielun;
		this.removedate = removedate;
		this.projId = projId;
		this.createTime = createTime;
	}

	public NobCheck() {
		super();
	}

}
