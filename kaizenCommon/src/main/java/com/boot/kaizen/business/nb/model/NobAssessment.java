package com.boot.kaizen.business.nb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 达标评估测试结果
 * 
 * @author weichengz
 * @date 2019年4月23日 下午2:49:53
 */
public class NobAssessment implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;// 主键 自动生成
	private String userId;// 用户ID
	private String testDate;// 测试时间
	private String station_No;// 测试时间
	private String communityName;// 小区名(小区ID也行)
	private String cellId;// CELL ID
	private String pci;// PCI
	private String frequency;// 频点
	private String longitude;// 经度
	private String latitude;// 纬度
	private String tac;// tac
	
	private String wireless_RSRP;// 无线信号的RSRP
	private String wireless_SINR;// 无线信号的SINR
	private String near_RSRP;// 邻区信号的RSRP
	private String a_Attempts;// 附着性能-尝试次数
	private String a_Success;// 附着性能-成功次数
	private String a_SuccessRatio;// 附着性能-成功率
	private String c_ReElection;// 重选性能-小区重选次数
	private String c_Success;// 重选性能-小区重选成功次数
	private String c_ReElectionRatio;// 重选性能-小区重选成功率
	private String p_Pttempts;// Ping性能-Ping尝试次数
	private String p_success;// Ping性能-Ping成功次数
	private String p_SuccessRadio;// Ping性能-Ping成功率
	private String p_Delay;// Ping性能-ping时延
	private String udp_UpRate;// 吞吐率性能-UDP上行速率
	private String udp_DownRate;// 吞吐率性能-UDP下行速率
	private String macUp;// 吞吐率性能-Mac上行
	private String macDown;// 吞吐率性能-Mac下行
	private String r_ReElectio;// 接入性能-RRC次数
	private String r_Success;// 接入性能-RRC成功次数
	private String r_ReElectionRatio;// 接入性能-RRC成功率
	

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

	public String getWireless_RSRP() {
		return wireless_RSRP;
	}

	public void setWireless_RSRP(String wireless_RSRP) {
		this.wireless_RSRP = wireless_RSRP;
	}

	public String getWireless_SINR() {
		return wireless_SINR;
	}

	public void setWireless_SINR(String wireless_SINR) {
		this.wireless_SINR = wireless_SINR;
	}

	public String getNear_RSRP() {
		return near_RSRP;
	}

	public void setNear_RSRP(String near_RSRP) {
		this.near_RSRP = near_RSRP;
	}

	public String getA_Attempts() {
		return a_Attempts;
	}

	public void setA_Attempts(String a_Attempts) {
		this.a_Attempts = a_Attempts;
	}

	public String getA_Success() {
		return a_Success;
	}

	public void setA_Success(String a_Success) {
		this.a_Success = a_Success;
	}

	public String getA_SuccessRatio() {
		return a_SuccessRatio;
	}

	public void setA_SuccessRatio(String a_SuccessRatio) {
		this.a_SuccessRatio = a_SuccessRatio;
	}

	public String getC_ReElection() {
		return c_ReElection;
	}

	public void setC_ReElection(String c_ReElection) {
		this.c_ReElection = c_ReElection;
	}

	public String getC_Success() {
		return c_Success;
	}

	public void setC_Success(String c_Success) {
		this.c_Success = c_Success;
	}

	public String getC_ReElectionRatio() {
		return c_ReElectionRatio;
	}

	public void setC_ReElectionRatio(String c_ReElectionRatio) {
		this.c_ReElectionRatio = c_ReElectionRatio;
	}

	public String getP_Pttempts() {
		return p_Pttempts;
	}

	public void setP_Pttempts(String p_Pttempts) {
		this.p_Pttempts = p_Pttempts;
	}

	public String getP_success() {
		return p_success;
	}

	public void setP_success(String p_success) {
		this.p_success = p_success;
	}

	public String getP_SuccessRadio() {
		return p_SuccessRadio;
	}

	public void setP_SuccessRadio(String p_SuccessRadio) {
		this.p_SuccessRadio = p_SuccessRadio;
	}

	public String getP_Delay() {
		return p_Delay;
	}

	public void setP_Delay(String p_Delay) {
		this.p_Delay = p_Delay;
	}

	public String getUdp_UpRate() {
		return udp_UpRate;
	}

	public void setUdp_UpRate(String udp_UpRate) {
		this.udp_UpRate = udp_UpRate;
	}

	public String getUdp_DownRate() {
		return udp_DownRate;
	}

	public void setUdp_DownRate(String udp_DownRate) {
		this.udp_DownRate = udp_DownRate;
	}

	public String getMacUp() {
		return macUp;
	}

	public void setMacUp(String macUp) {
		this.macUp = macUp;
	}

	public String getMacDown() {
		return macDown;
	}

	public void setMacDown(String macDown) {
		this.macDown = macDown;
	}

	public String getR_ReElectio() {
		return r_ReElectio;
	}

	public void setR_ReElectio(String r_ReElectio) {
		this.r_ReElectio = r_ReElectio;
	}

	public String getR_Success() {
		return r_Success;
	}

	public void setR_Success(String r_Success) {
		this.r_Success = r_Success;
	}

	public String getR_ReElectionRatio() {
		return r_ReElectionRatio;
	}

	public void setR_ReElectionRatio(String r_ReElectionRatio) {
		this.r_ReElectionRatio = r_ReElectionRatio;
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

	public String getTac() {
		return tac;
	}

	public void setTac(String tac) {
		this.tac = tac;
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

	public NobAssessment(String id, String userId, String testDate, String station_No, String communityName,
			String wireless_RSRP, String wireless_SINR, String near_RSRP, String a_Attempts, String a_Success,
			String a_SuccessRatio, String c_ReElection, String c_Success, String c_ReElectionRatio, String p_Pttempts,
			String p_success, String p_SuccessRadio, String p_Delay, String udp_UpRate, String udp_DownRate,
			String macUp, String macDown, String r_ReElectio, String r_Success, String r_ReElectionRatio, String cellId,
			String pci, String frequency, String longitude, String latitude, String tac, Integer projId,
			Date createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.testDate = testDate;
		this.station_No = station_No;
		this.communityName = communityName;
		this.wireless_RSRP = wireless_RSRP;
		this.wireless_SINR = wireless_SINR;
		this.near_RSRP = near_RSRP;
		this.a_Attempts = a_Attempts;
		this.a_Success = a_Success;
		this.a_SuccessRatio = a_SuccessRatio;
		this.c_ReElection = c_ReElection;
		this.c_Success = c_Success;
		this.c_ReElectionRatio = c_ReElectionRatio;
		this.p_Pttempts = p_Pttempts;
		this.p_success = p_success;
		this.p_SuccessRadio = p_SuccessRadio;
		this.p_Delay = p_Delay;
		this.udp_UpRate = udp_UpRate;
		this.udp_DownRate = udp_DownRate;
		this.macUp = macUp;
		this.macDown = macDown;
		this.r_ReElectio = r_ReElectio;
		this.r_Success = r_Success;
		this.r_ReElectionRatio = r_ReElectionRatio;
		this.cellId = cellId;
		this.pci = pci;
		this.frequency = frequency;
		this.longitude = longitude;
		this.latitude = latitude;
		this.tac = tac;
		this.projId = projId;
		this.createTime = createTime;
	}

	public NobAssessment() {
		super();
	}

}
