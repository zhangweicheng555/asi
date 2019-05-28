package com.boot.kaizen.business.nb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * NB迁移工参表信息
 * 
 * @author weichengz
 * @date 2019年4月22日 上午11:30:42
 */
public class NobGcb implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nodebid;// NodeB ID 整数
	private String jzname;// 基站名称
	private String cellid;// Cell ID 扇区 整数
	private String cellname;// 小区名称
	private String longitude;// 经度 最多小数点后六位
	private String latitude;// 纬度 最多小数点后六位
	private String elevation;// 海拔 整数
	private String tac;// TAC 整数
	private String fqpoint;// 频点 整数
	private String pci;// PCI 整数
	private String rspower;// RsPower 小数点后一位
	private String txgg;// 天线挂高 整数
	private String fxj;// 方向角 整数
	private String zxqj;// 总下倾角 整数
	private String dxqj;// 电下倾角 整数
	private String jxxqj;// 机械下倾角 整数
	private String finishflag;// 这个直接用于存储导入的时候的配置项了

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

	public void setNodebid(String nodebid) {
		this.nodebid = nodebid;
	}

	public String getJzname() {
		return jzname;
	}

	public void setJzname(String jzname) {
		this.jzname = jzname;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public String getTac() {
		return tac;
	}

	public void setTac(String tac) {
		this.tac = tac;
	}

	public String getCellid() {
		return cellid;
	}

	public void setCellid(String cellid) {
		this.cellid = cellid;
	}

	public String getCellname() {
		return cellname;
	}

	public void setCellname(String cellname) {
		this.cellname = cellname;
	}

	public String getFqpoint() {
		return fqpoint;
	}

	public void setFqpoint(String fqpoint) {
		this.fqpoint = fqpoint;
	}

	public String getPci() {
		return pci;
	}

	public void setPci(String pci) {
		this.pci = pci;
	}

	public String getRspower() {
		return rspower;
	}

	public void setRspower(String rspower) {
		this.rspower = rspower;
	}

	public String getTxgg() {
		return txgg;
	}

	public void setTxgg(String txgg) {
		this.txgg = txgg;
	}

	public String getFxj() {
		return fxj;
	}

	public void setFxj(String fxj) {
		this.fxj = fxj;
	}

	public String getZxqj() {
		return zxqj;
	}

	public void setZxqj(String zxqj) {
		this.zxqj = zxqj;
	}

	public String getDxqj() {
		return dxqj;
	}

	public void setDxqj(String dxqj) {
		this.dxqj = dxqj;
	}

	public String getJxxqj() {
		return jxxqj;
	}

	public void setJxxqj(String jxxqj) {
		this.jxxqj = jxxqj;
	}

	public String getFinishflag() {
		return finishflag;
	}

	public void setFinishflag(String finishflag) {
		this.finishflag = finishflag;
	}

	public NobGcb(String id, String nodebid, String jzname, String longitude, String latitude, String elevation,
			String tac, String cellid, String cellname, String fqpoint, String pci, String rspower, String txgg,
			String fxj, String zxqj, String dxqj, String jxxqj, String finishflag) {
		super();
		this.id = id;
		this.nodebid = nodebid;
		this.jzname = jzname;
		this.longitude = longitude;
		this.latitude = latitude;
		this.elevation = elevation;
		this.tac = tac;
		this.cellid = cellid;
		this.cellname = cellname;
		this.fqpoint = fqpoint;
		this.pci = pci;
		this.rspower = rspower;
		this.txgg = txgg;
		this.fxj = fxj;
		this.zxqj = zxqj;
		this.dxqj = dxqj;
		this.jxxqj = jxxqj;
		this.finishflag = finishflag;
	}

	public NobGcb() {
		super();
	}

}
