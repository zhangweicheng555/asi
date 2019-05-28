package com.boot.kaizen.business.nb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试配置项
 * 
 * @author weichengz
 * @date 2019年4月22日 下午7:00:10
 */
public class NobTest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;// 主键 自动生成
	private String pzname;// 配置名称

	/**
	 * 小区工程参数
	 */
	// 配置
	private String cellid;// Cell ID 扇区
	private String fqpoint;// 频点
	private String pci;// PCI
	// 目标
	private String cellid1;// Cell ID 扇区
	private String fqpoint1;// 频点
	private String pci1;// PCI
	/**
	 * 小区网优参数
	 */
	// 配置
	private String rspower;// RsPower
	private String txgg;// 天线挂高
	private String fxj;// 方向角
	private String zxqj;// 总下倾角
	private String dxqj;// 电下倾角
	private String jxxqj;// 机械下倾角
	// 目标
	private String rspower1;// RsPower
	private String txgg1;// 天线挂高
	private String fxj1;// 方向角
	private String zxqj1;// 总下倾角
	private String dxqj1;// 电下倾角
	private String jxxqj1;// 机械下倾角
	/**
	 * 附着性能
	 */
	// 配置
	private String attempt;// Attach attempts
	private String attsuccess;// Attach success
	private String attratio;// Attach Success Ratio
	// 目标
	private String attempt1;// Attach attempts
	private String attsuccess1;// Attach success
	private String attratio1;// Attach Success Ratio
	/**
	 * 重选性能
	 */
	// 配置
	private String xqcxcs;// 小区重选次数
	private String xqcxcgcs;// 小区重选成功次数
	private String xqcxcgl;// 小区重选成功率
	// 目标
	private String xqcxcs1;// 小区重选次数
	private String xqcxcgcs1;// 小区重选成功次数
	private String xqcxcgl1;// 小区重选成功率
	/**
	 * 接入性能
	 */
	// 配置
	private String rrcljcs;// RRC连接次数
	private String rrcljcgcs;// RRC连接成功次数
	private String rrcljcgl;// RRC连接成功率
	// 目标
	private String rrcljcs1;// RRC连接次数
	private String rrcljcgcs1;// RRC连接成功次数
	private String rrcljcgl1;// RRC连接成功率
	/**
	 * ping性能
	 */
	// 配置
	private String pingatt;// Ping attempts
	private String pingsucc;// Ping success
	private String pingratio;// Ping success Ratio
	private String pindelay;// Ping Delay
	// 目标
	private String pingatt1;// Ping attempts
	private String pingsucc1;// Ping success
	private String pingratio1;// Ping success Ratio
	private String pindelay1;// Ping Delay
	/**
	 * 吞吐率性能
	 */
	// 配置
	private String sxsl;// 上行速率
	private String xxsl;// 下行速率
	private String macsxsl;// MAC层上行速率
	private String macxxsl;// MAC层下行速率
	// 目标
	private String sxsl1;// 上行速率
	private String xxsl1;// 下行速率
	private String macsxsl1;// MAC层上行速率
	private String macxxsl1;// MAC层下行速率
	/**
	 * 无线信号
	 */
	// 配置
	private String wirelesscount;// 次数
	private String avgrsrp;// 平均RSRP
	private String avgsinr;// 平均sinr
	// 目标
	private String wirelesscount1;// 次数
	private String avgrsrp1;// 平均RSRP
	private String avgsinr1;// 平均sinr

	/**
	 * 上行配置参数
	 */
	// 配置
	private String mupSize;// 发包大小
	private String mupCount;// 发包次数
	private String mupIP;// 服务器地址(ip)
	private String mupPort;// 端口
	// 目标
	private String mupSize1;// 发包大小
	private String mupCount1;// 发包次数
	private String mupIP1;// 服务器地址(ip)
	private String mupPort1;// 端口
	/**
	 * 下行配置参数
	 */
	// 配置
	private String mdownSize;// 发包大小
	private String mdownCount;// 发包次数
	private String mdownIP;// 服务器地址(ip)
	private String mdownPort;// 端口
	// 目标
	private String mdownSize1;// 发包大小
	private String mdownCount1;// 发包次数
	private String mdownIP1;// 服务器地址(ip)
	private String mdownPort1;// 端口

	/**
	 * Ping配置
	 */
	// 配置
	private String mpingIP;// Ping地址
	private String mpingSize;// 发送的数据包大小
	private String mpingCount;// Ping次数
	private String mpingInterval;// 发包间隔
	// 目标
	private String mpingIP1;// Ping地址
	private String mpingSize1;// 发送的数据包大小
	private String mpingCount1;// Ping次数
	private String mpingInterval1;// 发包间隔

	// common
	private Integer projId;
	private Date createTime;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPzname() {
		return pzname;
	}

	public void setPzname(String pzname) {
		this.pzname = pzname;
	}

	public String getCellid() {
		return cellid;
	}

	public void setCellid(String cellid) {
		this.cellid = cellid;
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

	public String getCellid1() {
		return cellid1;
	}

	public void setCellid1(String cellid1) {
		this.cellid1 = cellid1;
	}

	public String getFqpoint1() {
		return fqpoint1;
	}

	public void setFqpoint1(String fqpoint1) {
		this.fqpoint1 = fqpoint1;
	}

	public String getPci1() {
		return pci1;
	}

	public void setPci1(String pci1) {
		this.pci1 = pci1;
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

	public String getRspower1() {
		return rspower1;
	}

	public void setRspower1(String rspower1) {
		this.rspower1 = rspower1;
	}

	public String getTxgg1() {
		return txgg1;
	}

	public void setTxgg1(String txgg1) {
		this.txgg1 = txgg1;
	}

	public String getFxj1() {
		return fxj1;
	}

	public void setFxj1(String fxj1) {
		this.fxj1 = fxj1;
	}

	public String getZxqj1() {
		return zxqj1;
	}

	public void setZxqj1(String zxqj1) {
		this.zxqj1 = zxqj1;
	}

	public String getDxqj1() {
		return dxqj1;
	}

	public void setDxqj1(String dxqj1) {
		this.dxqj1 = dxqj1;
	}

	public String getJxxqj1() {
		return jxxqj1;
	}

	public void setJxxqj1(String jxxqj1) {
		this.jxxqj1 = jxxqj1;
	}

	public String getAttempt() {
		return attempt;
	}

	public void setAttempt(String attempt) {
		this.attempt = attempt;
	}

	public String getAttsuccess() {
		return attsuccess;
	}

	public void setAttsuccess(String attsuccess) {
		this.attsuccess = attsuccess;
	}

	public String getAttratio() {
		return attratio;
	}

	public void setAttratio(String attratio) {
		this.attratio = attratio;
	}

	public String getAttempt1() {
		return attempt1;
	}

	public void setAttempt1(String attempt1) {
		this.attempt1 = attempt1;
	}

	public String getAttsuccess1() {
		return attsuccess1;
	}

	public void setAttsuccess1(String attsuccess1) {
		this.attsuccess1 = attsuccess1;
	}

	public String getAttratio1() {
		return attratio1;
	}

	public void setAttratio1(String attratio1) {
		this.attratio1 = attratio1;
	}

	public String getXqcxcs() {
		return xqcxcs;
	}

	public void setXqcxcs(String xqcxcs) {
		this.xqcxcs = xqcxcs;
	}

	public String getXqcxcgcs() {
		return xqcxcgcs;
	}

	public void setXqcxcgcs(String xqcxcgcs) {
		this.xqcxcgcs = xqcxcgcs;
	}

	public String getXqcxcgl() {
		return xqcxcgl;
	}

	public void setXqcxcgl(String xqcxcgl) {
		this.xqcxcgl = xqcxcgl;
	}

	public String getXqcxcs1() {
		return xqcxcs1;
	}

	public void setXqcxcs1(String xqcxcs1) {
		this.xqcxcs1 = xqcxcs1;
	}

	public String getXqcxcgcs1() {
		return xqcxcgcs1;
	}

	public void setXqcxcgcs1(String xqcxcgcs1) {
		this.xqcxcgcs1 = xqcxcgcs1;
	}

	public String getXqcxcgl1() {
		return xqcxcgl1;
	}

	public void setXqcxcgl1(String xqcxcgl1) {
		this.xqcxcgl1 = xqcxcgl1;
	}

	public String getRrcljcs() {
		return rrcljcs;
	}

	public void setRrcljcs(String rrcljcs) {
		this.rrcljcs = rrcljcs;
	}

	public String getRrcljcgcs() {
		return rrcljcgcs;
	}

	public void setRrcljcgcs(String rrcljcgcs) {
		this.rrcljcgcs = rrcljcgcs;
	}

	public String getRrcljcgl() {
		return rrcljcgl;
	}

	public void setRrcljcgl(String rrcljcgl) {
		this.rrcljcgl = rrcljcgl;
	}

	public String getRrcljcs1() {
		return rrcljcs1;
	}

	public void setRrcljcs1(String rrcljcs1) {
		this.rrcljcs1 = rrcljcs1;
	}

	public String getRrcljcgcs1() {
		return rrcljcgcs1;
	}

	public void setRrcljcgcs1(String rrcljcgcs1) {
		this.rrcljcgcs1 = rrcljcgcs1;
	}

	public String getRrcljcgl1() {
		return rrcljcgl1;
	}

	public void setRrcljcgl1(String rrcljcgl1) {
		this.rrcljcgl1 = rrcljcgl1;
	}

	public String getPingatt() {
		return pingatt;
	}

	public void setPingatt(String pingatt) {
		this.pingatt = pingatt;
	}

	public String getPingsucc() {
		return pingsucc;
	}

	public void setPingsucc(String pingsucc) {
		this.pingsucc = pingsucc;
	}

	public String getPingratio() {
		return pingratio;
	}

	public void setPingratio(String pingratio) {
		this.pingratio = pingratio;
	}

	public String getPindelay() {
		return pindelay;
	}

	public void setPindelay(String pindelay) {
		this.pindelay = pindelay;
	}

	public String getPingatt1() {
		return pingatt1;
	}

	public void setPingatt1(String pingatt1) {
		this.pingatt1 = pingatt1;
	}

	public String getPingsucc1() {
		return pingsucc1;
	}

	public void setPingsucc1(String pingsucc1) {
		this.pingsucc1 = pingsucc1;
	}

	public String getPingratio1() {
		return pingratio1;
	}

	public void setPingratio1(String pingratio1) {
		this.pingratio1 = pingratio1;
	}

	public String getPindelay1() {
		return pindelay1;
	}

	public void setPindelay1(String pindelay1) {
		this.pindelay1 = pindelay1;
	}

	public String getSxsl() {
		return sxsl;
	}

	public void setSxsl(String sxsl) {
		this.sxsl = sxsl;
	}

	public String getXxsl() {
		return xxsl;
	}

	public void setXxsl(String xxsl) {
		this.xxsl = xxsl;
	}

	public String getMacsxsl() {
		return macsxsl;
	}

	public void setMacsxsl(String macsxsl) {
		this.macsxsl = macsxsl;
	}

	public String getMacxxsl() {
		return macxxsl;
	}

	public void setMacxxsl(String macxxsl) {
		this.macxxsl = macxxsl;
	}

	public String getSxsl1() {
		return sxsl1;
	}

	public void setSxsl1(String sxsl1) {
		this.sxsl1 = sxsl1;
	}

	public String getXxsl1() {
		return xxsl1;
	}

	public void setXxsl1(String xxsl1) {
		this.xxsl1 = xxsl1;
	}

	public String getMacsxsl1() {
		return macsxsl1;
	}

	public void setMacsxsl1(String macsxsl1) {
		this.macsxsl1 = macsxsl1;
	}

	public String getMacxxsl1() {
		return macxxsl1;
	}

	public void setMacxxsl1(String macxxsl1) {
		this.macxxsl1 = macxxsl1;
	}

	public String getWirelesscount() {
		return wirelesscount;
	}

	public void setWirelesscount(String wirelesscount) {
		this.wirelesscount = wirelesscount;
	}

	public String getAvgrsrp() {
		return avgrsrp;
	}

	public void setAvgrsrp(String avgrsrp) {
		this.avgrsrp = avgrsrp;
	}

	public String getAvgsinr() {
		return avgsinr;
	}

	public void setAvgsinr(String avgsinr) {
		this.avgsinr = avgsinr;
	}

	public String getWirelesscount1() {
		return wirelesscount1;
	}

	public void setWirelesscount1(String wirelesscount1) {
		this.wirelesscount1 = wirelesscount1;
	}

	public String getAvgrsrp1() {
		return avgrsrp1;
	}

	public void setAvgrsrp1(String avgrsrp1) {
		this.avgrsrp1 = avgrsrp1;
	}

	public String getAvgsinr1() {
		return avgsinr1;
	}

	public void setAvgsinr1(String avgsinr1) {
		this.avgsinr1 = avgsinr1;
	}

	public String getMupSize() {
		return mupSize;
	}

	public void setMupSize(String mupSize) {
		this.mupSize = mupSize;
	}

	public String getMupCount() {
		return mupCount;
	}

	public void setMupCount(String mupCount) {
		this.mupCount = mupCount;
	}

	public String getMupIP() {
		return mupIP;
	}

	public void setMupIP(String mupIP) {
		this.mupIP = mupIP;
	}

	public String getMupPort() {
		return mupPort;
	}

	public void setMupPort(String mupPort) {
		this.mupPort = mupPort;
	}

	public String getMupSize1() {
		return mupSize1;
	}

	public void setMupSize1(String mupSize1) {
		this.mupSize1 = mupSize1;
	}

	public String getMupCount1() {
		return mupCount1;
	}

	public void setMupCount1(String mupCount1) {
		this.mupCount1 = mupCount1;
	}

	public String getMupIP1() {
		return mupIP1;
	}

	public void setMupIP1(String mupIP1) {
		this.mupIP1 = mupIP1;
	}

	public String getMupPort1() {
		return mupPort1;
	}

	public void setMupPort1(String mupPort1) {
		this.mupPort1 = mupPort1;
	}

	public String getMdownSize() {
		return mdownSize;
	}

	public void setMdownSize(String mdownSize) {
		this.mdownSize = mdownSize;
	}

	public String getMdownCount() {
		return mdownCount;
	}

	public void setMdownCount(String mdownCount) {
		this.mdownCount = mdownCount;
	}

	public String getMdownIP() {
		return mdownIP;
	}

	public void setMdownIP(String mdownIP) {
		this.mdownIP = mdownIP;
	}

	public String getMdownPort() {
		return mdownPort;
	}

	public void setMdownPort(String mdownPort) {
		this.mdownPort = mdownPort;
	}

	public String getMdownSize1() {
		return mdownSize1;
	}

	public void setMdownSize1(String mdownSize1) {
		this.mdownSize1 = mdownSize1;
	}

	public String getMdownCount1() {
		return mdownCount1;
	}

	public void setMdownCount1(String mdownCount1) {
		this.mdownCount1 = mdownCount1;
	}

	public String getMdownIP1() {
		return mdownIP1;
	}

	public void setMdownIP1(String mdownIP1) {
		this.mdownIP1 = mdownIP1;
	}

	public String getMdownPort1() {
		return mdownPort1;
	}

	public void setMdownPort1(String mdownPort1) {
		this.mdownPort1 = mdownPort1;
	}

	public String getMpingIP() {
		return mpingIP;
	}

	public void setMpingIP(String mpingIP) {
		this.mpingIP = mpingIP;
	}

	public String getMpingSize() {
		return mpingSize;
	}

	public void setMpingSize(String mpingSize) {
		this.mpingSize = mpingSize;
	}

	public String getMpingCount() {
		return mpingCount;
	}

	public void setMpingCount(String mpingCount) {
		this.mpingCount = mpingCount;
	}

	public String getMpingInterval() {
		return mpingInterval;
	}

	public void setMpingInterval(String mpingInterval) {
		this.mpingInterval = mpingInterval;
	}

	public String getMpingIP1() {
		return mpingIP1;
	}

	public void setMpingIP1(String mpingIP1) {
		this.mpingIP1 = mpingIP1;
	}

	public String getMpingSize1() {
		return mpingSize1;
	}

	public void setMpingSize1(String mpingSize1) {
		this.mpingSize1 = mpingSize1;
	}

	public String getMpingCount1() {
		return mpingCount1;
	}

	public void setMpingCount1(String mpingCount1) {
		this.mpingCount1 = mpingCount1;
	}

	public String getMpingInterval1() {
		return mpingInterval1;
	}

	public void setMpingInterval1(String mpingInterval1) {
		this.mpingInterval1 = mpingInterval1;
	}

	public NobTest(String id, String pzname, String cellid, String fqpoint, String pci, String cellid1, String fqpoint1,
			String pci1, String rspower, String txgg, String fxj, String zxqj, String dxqj, String jxxqj,
			String rspower1, String txgg1, String fxj1, String zxqj1, String dxqj1, String jxxqj1, String attempt,
			String attsuccess, String attratio, String attempt1, String attsuccess1, String attratio1, String xqcxcs,
			String xqcxcgcs, String xqcxcgl, String xqcxcs1, String xqcxcgcs1, String xqcxcgl1, String rrcljcs,
			String rrcljcgcs, String rrcljcgl, String rrcljcs1, String rrcljcgcs1, String rrcljcgl1, String pingatt,
			String pingsucc, String pingratio, String pindelay, String pingatt1, String pingsucc1, String pingratio1,
			String pindelay1, String sxsl, String xxsl, String macsxsl, String macxxsl, String sxsl1, String xxsl1,
			String macsxsl1, String macxxsl1, String wirelesscount, String avgrsrp, String avgsinr,
			String wirelesscount1, String avgrsrp1, String avgsinr1, String mupSize, String mupCount, String mupIP,
			String mupPort, String mupSize1, String mupCount1, String mupIP1, String mupPort1, String mdownSize,
			String mdownCount, String mdownIP, String mdownPort, String mdownSize1, String mdownCount1, String mdownIP1,
			String mdownPort1, String mpingIP, String mpingSize, String mpingCount, String mpingInterval,
			String mpingIP1, String mpingSize1, String mpingCount1, String mpingInterval1) {
		super();
		this.id = id;
		this.pzname = pzname;
		this.cellid = cellid;
		this.fqpoint = fqpoint;
		this.pci = pci;
		this.cellid1 = cellid1;
		this.fqpoint1 = fqpoint1;
		this.pci1 = pci1;
		this.rspower = rspower;
		this.txgg = txgg;
		this.fxj = fxj;
		this.zxqj = zxqj;
		this.dxqj = dxqj;
		this.jxxqj = jxxqj;
		this.rspower1 = rspower1;
		this.txgg1 = txgg1;
		this.fxj1 = fxj1;
		this.zxqj1 = zxqj1;
		this.dxqj1 = dxqj1;
		this.jxxqj1 = jxxqj1;
		this.attempt = attempt;
		this.attsuccess = attsuccess;
		this.attratio = attratio;
		this.attempt1 = attempt1;
		this.attsuccess1 = attsuccess1;
		this.attratio1 = attratio1;
		this.xqcxcs = xqcxcs;
		this.xqcxcgcs = xqcxcgcs;
		this.xqcxcgl = xqcxcgl;
		this.xqcxcs1 = xqcxcs1;
		this.xqcxcgcs1 = xqcxcgcs1;
		this.xqcxcgl1 = xqcxcgl1;
		this.rrcljcs = rrcljcs;
		this.rrcljcgcs = rrcljcgcs;
		this.rrcljcgl = rrcljcgl;
		this.rrcljcs1 = rrcljcs1;
		this.rrcljcgcs1 = rrcljcgcs1;
		this.rrcljcgl1 = rrcljcgl1;
		this.pingatt = pingatt;
		this.pingsucc = pingsucc;
		this.pingratio = pingratio;
		this.pindelay = pindelay;
		this.pingatt1 = pingatt1;
		this.pingsucc1 = pingsucc1;
		this.pingratio1 = pingratio1;
		this.pindelay1 = pindelay1;
		this.sxsl = sxsl;
		this.xxsl = xxsl;
		this.macsxsl = macsxsl;
		this.macxxsl = macxxsl;
		this.sxsl1 = sxsl1;
		this.xxsl1 = xxsl1;
		this.macsxsl1 = macsxsl1;
		this.macxxsl1 = macxxsl1;
		this.wirelesscount = wirelesscount;
		this.avgrsrp = avgrsrp;
		this.avgsinr = avgsinr;
		this.wirelesscount1 = wirelesscount1;
		this.avgrsrp1 = avgrsrp1;
		this.avgsinr1 = avgsinr1;
		this.mupSize = mupSize;
		this.mupCount = mupCount;
		this.mupIP = mupIP;
		this.mupPort = mupPort;
		this.mupSize1 = mupSize1;
		this.mupCount1 = mupCount1;
		this.mupIP1 = mupIP1;
		this.mupPort1 = mupPort1;
		this.mdownSize = mdownSize;
		this.mdownCount = mdownCount;
		this.mdownIP = mdownIP;
		this.mdownPort = mdownPort;
		this.mdownSize1 = mdownSize1;
		this.mdownCount1 = mdownCount1;
		this.mdownIP1 = mdownIP1;
		this.mdownPort1 = mdownPort1;
		this.mpingIP = mpingIP;
		this.mpingSize = mpingSize;
		this.mpingCount = mpingCount;
		this.mpingInterval = mpingInterval;
		this.mpingIP1 = mpingIP1;
		this.mpingSize1 = mpingSize1;
		this.mpingCount1 = mpingCount1;
		this.mpingInterval1 = mpingInterval1;
	}

	public NobTest() {
		super();
	}

}