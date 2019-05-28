package com.boot.kaizen.business.nb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.boot.kaizen.business.nb.model.NobAssessment;
import com.boot.kaizen.business.nb.model.NobGcb;
import com.boot.kaizen.business.nb.model.NobParamcheck;
import com.boot.kaizen.business.nb.model.NobPlan;
import com.boot.kaizen.business.nb.model.NobRoadInfo;
import com.boot.kaizen.business.nb.model.NobTest;
import com.boot.kaizen.business.nb.model.entity.BaseStationBean;
import com.boot.kaizen.business.nb.model.entity.CommunityBean;
import com.boot.kaizen.business.nb.model.entity.MCommunityNetworkOptimizationBean;
import com.boot.kaizen.business.nb.model.entity.MCommunityProjectBean;
import com.boot.kaizen.business.nb.model.entity.MTestPlanBean;
import com.boot.kaizen.business.nb.service.INobAssessmentService;
import com.boot.kaizen.business.nb.service.INobGcbService;
import com.boot.kaizen.business.nb.service.INobParameterService;
import com.boot.kaizen.business.nb.service.INobPlanService;
import com.boot.kaizen.business.nb.service.INobRoadInfoService;
import com.boot.kaizen.business.nb.service.INobTestService;
import com.boot.kaizen.model.SysUser;
import com.boot.kaizen.service.SysProjectService;
import com.boot.kaizen.service.UserService;
import com.boot.kaizen.util.AppUtil;
import com.boot.kaizen.util.FileUtil;
import com.boot.kaizen.util.MyDateUtil;
import com.boot.kaizen.util.MyUtil;

/**
 * Nob app端
 * 
 * @author weichengz
 * @date 2019年4月23日 下午4:01:49
 */
@Controller
@RequestMapping("/nob/app")
public class NobAppController {

	@Value("${files.path}")
	private String filesPath;
	@Autowired
	private INobAssessmentService nobAssessmentService;
	@Autowired
	private INobParameterService nobParameterService;
	@Autowired
	private INobRoadInfoService nobRoadInfoService;
	@Autowired
	private INobTestService nobTestService;
	@Autowired
	private INobPlanService nobPlanService;
	@Autowired
	private INobGcbService nobGcbService;
	@Autowired
	private SysProjectService projectService;
	@Value("${files.nobitDocExcel}")
	private String nobitDocExcel;
	@Autowired
	private UserService userService;

	/**
	 * 
	 * @Description: 上传达标评估测试结果
	 * @author weichengz
	 * @date 2019年4月23日 下午4:51:49
	 */
	@ResponseBody
	@RequestMapping(value = "/upNobAssessmentData", method = { RequestMethod.POST, RequestMethod.GET })
	public AppUtil upNobAssessmentData(NobAssessment nobAssessment) {
		AppUtil appUtil = new AppUtil(1, "上传达标评估测试结果成功", "");
		try {
			nobAssessmentService.editApp(nobAssessment);
			return appUtil;
		} catch (Exception e) {
			appUtil = new AppUtil(2, "系统异常：" + e.getMessage(), "");
			return appUtil;
		}
	}

	/**
	 * 
	 * @Description: 上传参数核查
	 * @author weichengz
	 * @date 2019年4月23日 下午4:51:49
	 */
	@ResponseBody
	@RequestMapping(value = "/upNobParamcheckData", method = { RequestMethod.POST, RequestMethod.GET })
	public AppUtil upNobParamcheckData(NobParamcheck nobParamcheck) {
		AppUtil appUtil = new AppUtil(1, "上传参数核查结果成功", "");
		try {
			nobParameterService.editApp(nobParamcheck);
			return appUtil;
		} catch (Exception e) {
			appUtil = new AppUtil(2, "系统异常：" + e.getMessage(), "");
			return appUtil;
		}
	}

	/**
	 * 上传路测信息
	 * 
	 * @Description: TODO
	 * @author weichengz
	 * @date 2019年4月25日 上午9:53:49
	 */
	@ResponseBody
	@RequestMapping(value = "/upRoadInfoData", method = RequestMethod.POST)
	public AppUtil upRoadInfoData(
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "station_No", required = false) String station_No,
			@RequestParam(value = "communityName", required = false) String communityName,
			@RequestParam(value = "projId", required = false) Integer projId,
			
			@RequestParam(value = "rtlist", required = false) MultipartFile rtlist,
			@RequestParam(value = "rsrpImage", required = false) MultipartFile rsrpImage,
			@RequestParam(value = "sinrImage", required = false) MultipartFile sinrImage,
			@RequestParam(value = "pciImage", required = false) MultipartFile pciImage,
			@RequestParam(value = "sinrThresholdImage", required = false) MultipartFile sinrThresholdImage,
			@RequestParam(value = "rsrpThresholdImage", required = false) MultipartFile rsrpThresholdImage,
			@RequestParam(value = "picThresholdImage", required = false) MultipartFile picThresholdImage) {
		AppUtil appUtil = new AppUtil(1, "上传成功", null);
		try {
			if (projId == null || StringUtils.isBlank(station_No) || StringUtils.isBlank(userId)) {
				appUtil = new AppUtil(0, "项目projId、用户userId、基站号station_No不能为空", "");
				return appUtil;
			}
			NobRoadInfo nobRoadInfo=new NobRoadInfo();
			nobRoadInfo.setUserId(userId);
			nobRoadInfo.setStation_No(station_No);
			nobRoadInfo.setCommunityName(communityName);
			nobRoadInfo.setProjId(projId);
			
			String rtlistName = upFile(rtlist, "");
			String rsrpImageName = upFile(rsrpImage, "");
			String sinrImageName = upFile(sinrImage, "");
			String pciImageName = upFile(pciImage, "");
			String picThresholdImageName = upFile(picThresholdImage, "");
			String sinrThresholdImageName = upFile(sinrThresholdImage, "");
			String rsrpThresholdImageName = upFile(rsrpThresholdImage, "");
			nobRoadInfo.setRtlist(rtlistName);
			nobRoadInfo.setRsrpImage(rsrpImageName);
			nobRoadInfo.setSinrImage(sinrImageName);
			nobRoadInfo.setPciImage(pciImageName);
			nobRoadInfo.setPicThresholdImage(picThresholdImageName);
			nobRoadInfo.setRsrpThresholdImage(rsrpThresholdImageName);
			nobRoadInfo.setSinrThresholdImage(sinrThresholdImageName);
			
			appUtil.setDataSource("上传成功");
			nobRoadInfoService.editApp(nobRoadInfo, nobRoadInfo.getProjId());
			return appUtil;
		} catch (Exception e) {
			appUtil = new AppUtil(2, "系统异常：" + e.getMessage(), "");
			return appUtil;
		}
	}

	/**
	 * 查询测试配置项
	 * 
	 * @Description: TODO
	 * @author weichengz
	 * @date 2019年4月24日 下午1:32:41
	 */
	@ResponseBody
	@RequestMapping(value = "/queryNobTestList", method = { RequestMethod.POST, RequestMethod.GET })
	public AppUtil queryNobTestList(@RequestParam(value = "projId", required = false) Integer projId) {
		AppUtil appUtil = new AppUtil(1, "查询结果成功", "");
		if (projId == null) {
			appUtil = new AppUtil(0, "未传入项目的ID", "");
		} else {
			try {
				Map<String, Object> map = new HashMap<String, Object>();// 这是最后的map 直接给dataSource
				// 上行配置默认
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("mUPSize", "");
				map1.put("mUpCount", "");
				map1.put("mUpIP", "");
				map1.put("mUpPort", "");
				map1.put("mUpTarget", "");
				// 下行配置默认
				Map<String, Object> map2 = new HashMap<String, Object>();
				map2.put("mDownSize", "");
				map2.put("mDownCount", "");
				map2.put("mDownIP", "");
				map2.put("mDownPort", "");
				map2.put("mDownTarget", "");
				// Ping配置
				Map<String, Object> map3 = new HashMap<String, Object>();
				map3.put("mPingCount", "");
				map3.put("mPingIP", "");
				map3.put("mPingInterval", "");
				map3.put("mPingSize", "");
				map3.put("mPingSuccessRateTargett", "");
				map3.put("mPingDelayTarget", "");
				// 重选性能配置
				Map<String, Object> map4 = new HashMap<String, Object>();
				map4.put("mReelectionCount", "");
				map4.put("mReelectionTarget", "");
				// 接入性能配置参数
				Map<String, Object> map5 = new HashMap<String, Object>();
				map5.put("mRRCCount", "");
				map5.put("mRRCTarget", "");
				// 附着性能配置参数
				Map<String, Object> map6 = new HashMap<String, Object>();
				map6.put("mAttachedCount", "");
				map6.put("mAttachedTarget", "");
				// 无线性能配置
				Map<String, Object> map7 = new HashMap<String, Object>();
				map7.put("mWirelessCount", "");
				map7.put("mWirelessRsrpTarget", "");
				map7.put("mWirelessSINRTarget", "");

				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("projId", projId);
				List<NobTest> lisNobTestsM = nobTestService.find(paramMap);
				if (lisNobTestsM != null && lisNobTestsM.size() > 0) {
					NobTest nobTest = lisNobTestsM.get(0);
					// "上行配置"
					map1.put("mUPSize", nobTest.getMupSize());
					map1.put("mUpCount", nobTest.getMupCount());
					map1.put("mUpIP", nobTest.getMupIP());
					map1.put("mUpPort", nobTest.getMupPort());
					map1.put("mUpTarget", nobTest.getSxsl1());
					// "下行配置"
					map2.put("mDownSize", nobTest.getMdownSize());
					map2.put("mDownCount", nobTest.getMdownCount());
					map2.put("mDownIP", nobTest.getMdownIP());
					map2.put("mDownPort", nobTest.getMdownPort());
					map2.put("mDownTarget", nobTest.getXxsl1());
					// "Ping配置"
					map3.put("mPingCount", nobTest.getMpingCount());
					map3.put("mPingIP", nobTest.getMpingIP());
					map3.put("mPingInterval", nobTest.getMpingInterval());
					map3.put("mPingSize", nobTest.getMpingSize());
					map3.put("mPingSuccessRateTargett", nobTest.getPingratio1());
					map3.put("mPingDelayTarget", nobTest.getPindelay1());
					// 重选性能配置"
					map4.put("mReelectionCount", nobTest.getXqcxcs());
					map4.put("mReelectionTarget", nobTest.getXqcxcgl1());
					// 接入性能配置
					map5.put("mRRCCount", nobTest.getRrcljcs());
					map5.put("mRRCTarget", nobTest.getRrcljcgl1());
					// 附着性能配置
					map6.put("mAttachedCount", nobTest.getAttempt());
					map6.put("mAttachedTarget", nobTest.getAttratio1());
					// 无线性能配置
					map7.put("mWirelessCount", nobTest.getWirelesscount());
					map7.put("mWirelessRsrpTarget", nobTest.getAvgrsrp1());
					map7.put("mWirelessSINRTarget", nobTest.getAvgsinr1());

					map.put("mUpConfig", map1);
					map.put("mDownConfig", map2);
					map.put("mPingConfig", map3);
					map.put("mReelectionConfig", map4);
					map.put("mRrcConfig", map5);
					map.put("mAttachedConfig", map6);
					map.put("mWirelessConfig", map7);
					appUtil.setDataSource(map);
				} else {
					appUtil = new AppUtil(0, "查询的结果为空", "");
				}
			} catch (Exception e) {
				appUtil = new AppUtil(0, "服务器错误" + e.getLocalizedMessage(), "");
			}
		}
		return appUtil;
	}

	/**
	 * 根据测试时间、用户的id 项目id 查询计划表对应的对应的任务
	 * 
	 * @Description: TODO
	 * @author weichengz
	 * @date 2019年4月24日 下午1:48:52
	 */
	@ResponseBody
	@RequestMapping(value = "/queryPlanTaskList", method = { RequestMethod.POST, RequestMethod.GET })
	public AppUtil queryPlanTaskList(@RequestParam(value = "projId", required = false) Integer projId,
			@RequestParam(value = "testDate", required = false) String testDate,
			@RequestParam(value = "userId", required = false) String userId) {
		AppUtil appUtil = new AppUtil(1, "查询结果成功", "");
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(testDate) || projId == null) {
			appUtil = new AppUtil(0, "请输入用户ID、测试时间、项目的ID", "");
		} else {
			List<BaseStationBean> listBaseStationBean = new ArrayList<BaseStationBean>();// 存放站点的集合
			try {
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("planetesttime", testDate);
				paramMap.put("userid", userId);
				paramMap.put("projId", projId);
				List<NobPlan> lNobPlans = nobPlanService.find(paramMap);
				List<String> list = new ArrayList<String>();// 存放站号
				if (lNobPlans.size() > 0) {
					for (NobPlan nobPlan : lNobPlans) {
						if (!list.contains(nobPlan.getNodebid())) {
							list.add(nobPlan.getNodebid());
						}
					}
				}
				if (list.size() > 0) {// 有站号存在
					for (String nobid : list) {
						BaseStationBean baseStationBean = new BaseStationBean();
						Map<String, Object> paramGcMap = new HashMap<>();
						paramGcMap.put("nodebid", nobid);
						paramGcMap.put("projId", projId);
						List<NobGcb> lisNobGcbs = nobGcbService.find(paramGcMap);
						// 小区测试项 这里指定全部测试
						String st = "Ping性能,吞吐率性能,接入性能,附着性能,无线信号";
						List<String> listPzList = new ArrayList<String>();
						String[] strArray = st.split(",");
						for (int i = 0; i < strArray.length; i++) {
							String name = strArray[i];
							listPzList.add(name);
						}
						if (lisNobGcbs.size() > 0) {
							for (int i = 0; i < lisNobGcbs.size(); i++) {
								CommunityBean communityBean = new CommunityBean();
								NobGcb nobGcb = lisNobGcbs.get(i);
								if (i == 0) {
									baseStationBean.setmBaseStationNumber(nobid);
									baseStationBean.setmLatitude(nobGcb.getLatitude());
									baseStationBean.setmLongitude(nobGcb.getLongitude());
									baseStationBean.setmBaseStationName(nobGcb.getJzname());
									baseStationBean.setmAltitude(nobGcb.getElevation());
									baseStationBean.setmBaseStationNumber(nobGcb.getNodebid());
								}
								if (StringUtils.isNotBlank(nobGcb.getCellname())) {
									communityBean.setmCommunityBeanName(nobGcb.getCellname());
								}
								// 查询小区的测试项
								communityBean.setmCommunityTestItemList(listPzList);
								// 查询小区工程
								MCommunityProjectBean myBean = new MCommunityProjectBean();
								myBean.setmCellID(nobGcb.getCellid());
								myBean.setmFrequency(nobGcb.getFqpoint());
								myBean.setmPCI(nobGcb.getPci());
								communityBean.setmCommunityProject(myBean);
								// 查询小区网优参数
								MCommunityNetworkOptimizationBean mNOBean = new MCommunityNetworkOptimizationBean();
								mNOBean.setmRsPower(nobGcb.getRspower());
								mNOBean.setmAntennaHangUp(nobGcb.getTxgg());
								mNOBean.setmAzimuth(nobGcb.getFxj());
								mNOBean.setMtotalLowerInclination(nobGcb.getZxqj());
								mNOBean.setmPresetElectricDip(nobGcb.getDxqj());
								mNOBean.setmMechanicalLowerInclination(nobGcb.getJxxqj());
								communityBean.setmCommunityNetworkOptimization(mNOBean);

								baseStationBean.getmCommunityBeanList().add(communityBean);
							}
							listBaseStationBean.add(baseStationBean);
						}
					}
				}
				appUtil.setDataSource(listBaseStationBean);
			} catch (Exception e) {
				appUtil = new AppUtil(2, "服务器异常:" + e.getLocalizedMessage(), "");
			}
		}
		return appUtil;
	}

	/**
	 * 查询登陆账号 当天的测试任务 返回的是时间列表
	 * 
	 * @Description: TODO
	 * @author weichengz
	 * @date 2019年4月24日 下午2:34:43
	 */
	@ResponseBody
	@RequestMapping(value = "/queryPlanDateList", method = { RequestMethod.POST, RequestMethod.GET })
	public AppUtil queryPlanDateList(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "projId") Integer projId) {
		AppUtil appUtil = new AppUtil(1, "查询结果成功", "");
		if (StringUtils.isBlank(userId) || projId == null) {
			appUtil = new AppUtil(0, "请输入用户编号userId、项目编号projId", "");
		} else {
			try {
				List<String> list = new ArrayList<String>();
				List<MTestPlanBean> list2 = new ArrayList<MTestPlanBean>();
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("planetesttime", MyDateUtil.getNowDate("yyyy-MM-dd"));
				paramMap.put("userid", userId);
				paramMap.put("projId", projId);
				List<NobPlan> lNobPlans = nobPlanService.find(paramMap);
				if (lNobPlans.size() > 0) {
					for (NobPlan nobPlan : lNobPlans) {
						if (StringUtils.isNotBlank(nobPlan.getPlanetesttime())) {
							if (!list.contains(nobPlan.getPlanetesttime())) {
								list.add(nobPlan.getPlanetesttime());
							}
						}
					}
				}
				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						list2.add(new MTestPlanBean(list.get(i)));
					}
				}
				appUtil.setDataSource(list2);
			} catch (Exception e) {
				appUtil = new AppUtil(2, "服务器异常：" + e.getLocalizedMessage(), "");
			}
		}
		return appUtil;
	}

	/**
	 * 查询用户 所属的所有的项目
	 * 
	 * @Description: TODO
	 * @author weichengz
	 * @date 2019年4月24日 下午3:05:00
	 */
	@ResponseBody
	@RequestMapping(value = "/queryProjectList", method = { RequestMethod.POST, RequestMethod.GET })
	public AppUtil queryProjectList(@RequestParam(value = "name", required = true) String name) {
		AppUtil appUtil = new AppUtil(1, "查询成功", "");
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			List<Map<String, Object>> queryProjects = projectService.queryProjects(name);
			if (queryProjects == null || queryProjects.size() == 0) {
				appUtil = new AppUtil(0, "查询项目列表为空", "");
				return appUtil;
			}

			for (Map<String, Object> map : queryProjects) {
				Map<String, Object> model = new HashMap<>();
				Long projId = Long.valueOf(map.get("id").toString());
				model.put("proName", map.get("projName").toString());
				model.put("projId", projId);
				SysUser user = userService.queryUser(projId, name);
				model.put("userId", user.getId());
				list.add(model);
			}
			appUtil.setDataSource(list);
			return appUtil;
		} catch (Exception e) {
			appUtil = new AppUtil(2, "系统异常：" + e.getMessage(), "");
			return appUtil;
		}
	}

	// 登陆 获取token
	// http://localhost:8081/login?username=wuzhihua&password=wuzhihua

	/**
	 * stationNo 报告下载
	 * 
	 * @Description: TODO
	 * @author weichengz
	 * @date 2019年4月24日 下午3:33:48
	 */
	@RequestMapping(value = "/exportReport", method = { RequestMethod.POST, RequestMethod.GET })
	public void exportReport(@RequestParam(value = "projId", required = false) Integer projId,
			@RequestParam(value = "stationNo", required = false) String stationNo, HttpServletResponse response,
			HttpSession session) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();// 存取要存入excel的集合

		// 进行初始化工作
		map.put("title", "");// 标题
		map.put("jzname", "");// 基站名称
		map.put("plantestengineer", "");// 测试工程师
		map.put("plantestphone", "");// 测试电话
		map.put("planbackendengineer", "");// 后天工程师
		map.put("planbackendphone", "");// 后天工程师电话
		map.put("testTime", "");// 测试时间 查勘日期 这个即用于报告封面 也用于查看日期

		// 小区1设计
		map.put("longitude", "");// 经度
		map.put("latitude", "");// 纬度
		map.put("tac", "");// TAC
		map.put("stationNo", "");// 基站号
		map.put("cellid", "");// cellid
		map.put("fqpoint", "");// fqpoint
		map.put("pci", "");// pci
		map.put("txgg", "");// 天线挂高
		map.put("rspower", "");// RsPower
		map.put("fxj", "");// 方向角
		map.put("zxqj", "");// 总下倾角
		map.put("dxqj", "");// 电下倾角
		map.put("jxxqj", "");// 机械下倾角
		// 小区2设计
		map.put("longitude2", "");// 经度
		map.put("latitude2", "");// 纬度
		map.put("tac2", "");// TAC
		map.put("stationNo2", "");// 基站号
		map.put("cellid2", "");// cellid
		map.put("fqpoint2", "");// fqpoint
		map.put("pci2", "");// pci
		map.put("txgg2", "");// 天线挂高
		map.put("rspower2", "");// RsPower
		map.put("fxj2", "");// 方向角
		map.put("zxqj2", "");// 总下倾角
		map.put("dxqj2", "");// 电下倾角
		map.put("jxxqj2", "");// 机械下倾角
		// 小区3设计
		map.put("longitude3", "");// 经度
		map.put("latitude3", "");// 纬度
		map.put("tac3", "");// TAC
		map.put("stationNo3", "");// 基站号
		map.put("cellid3", "");// cellid
		map.put("fqpoint3", "");// fqpoint
		map.put("pci3", "");// pci
		map.put("txgg3", "");// 天线挂高
		map.put("rspower3", "");// RsPower
		map.put("fxj3", "");// 方向角
		map.put("zxqj3", "");// 总下倾角
		map.put("dxqj3", "");// 电下倾角
		map.put("jxxqj3", "");// 机械下倾角

		map.put("tacs", "");
		map.put("cellids", "");
		map.put("pcis", "");

		map.put("tacs2", "");
		map.put("cellids2", "");
		map.put("pcis2", "");

		map.put("tacs3", "");
		map.put("cellids3", "");
		map.put("pcis3", "");

		// 小区1
		map.put("wireless_RSRP", "");// 选线信号
		map.put("wireless_SINR", "");
		map.put("a_SuccessRatio", "");// 附着性能
		map.put("c_ReElectionRatio", "");// 重选性能
		map.put("r_ReElectionRatio", "");// rrc链接冲功率
		map.put("p_Delay", "");// //ping性能 ping时延
		map.put("p_SuccessRadio", "");// -Ping成功率
		map.put("macUp", "");// //mac -Ping成功率
		map.put("macDown", "");// -Ping成功率

		// 小区2
		map.put("wireless_RSRP2", "");// 选线信号
		map.put("wireless_SINR2", "");
		map.put("a_SuccessRatio2", "");// 附着性能
		map.put("c_ReElectionRatio2", "");// 重选性能
		map.put("r_ReElectionRatio2", "");// rrc链接冲功率
		map.put("p_Delay2", "");// //ping性能 ping时延
		map.put("p_SuccessRadio2", "");// -Ping成功率
		map.put("macUp2", "");// //mac -Ping成功率
		map.put("macDown2", "");// -Ping成功率

		// 小区3
		map.put("wireless_RSRP3", "");// 选线信号
		map.put("wireless_SINR3", "");
		map.put("a_SuccessRatio3", "");// 附着性能
		map.put("c_ReElectionRatio3", "");// 重选性能
		map.put("r_ReElectionRatio3", "");// rrc链接冲功率
		map.put("p_Delay3", "");// //ping性能 ping时延
		map.put("p_SuccessRadio3", "");// -Ping成功率
		map.put("macUp3", "");// //mac -Ping成功率
		map.put("macDown3", "");// -Ping成功率

		map.put("flag1", "start");// 经度比较
		map.put("flag2", "start");// 纬度
		map.put("flag3", "不一致");// tac
		map.put("flag4", "不一致");// cellid
		map.put("flag5", "不一致");// pci

		map.put("longitudes", "");// 经度
		map.put("latitudes", "");// 纬度
		map.put("longitudes2", "");// 经度
		map.put("latitudes2", "");// 纬度
		map.put("longitudes3", "");// 经度
		map.put("latitudes3", "");// 纬度

		if (StringUtils.isNotBlank(stationNo) && projId != null) {
			// 站点名称 测试人 测试时间 读测试规划表
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("nodebid", stationNo);
			paramMap.put("projId", projId);
			List<NobPlan> nobPlans = nobPlanService.find(paramMap);
			if (nobPlans != null && nobPlans.size() > 0) {
				NobPlan nobPlan = nobPlans.get(0);
				// 进行初始化工作
				map.put("title", nobPlan.getJzname() + "单站核查优化测试报告_" + MyDateUtil.getNowDate("yyyy-MM-dd"));// 标题
				map.put("jzname", nobPlan.getJzname());// 基站名称
				map.put("plantestengineer", nobPlan.getPlantestengineer());// 测试工程师
				map.put("plantestphone", nobPlan.getPlantestphone());// 测试电话
				map.put("planbackendengineer", nobPlan.getPlanbackendengineer());// 后天工程师
				map.put("planbackendphone", nobPlan.getPlanbackendphone());// 后天工程师电话
				map.put("testTime", nobPlan.getPlanetesttime());// 测试时间
			} else {
				map.put("title", "该站点不存在");// 标题
			}

			// 目前的基站参数都填写一样的 经度纬度tac nobid 读基站参数的一条记录
			List<NobGcb> lisNobGcbs = nobGcbService.find(paramMap);
			// 小区名列表
			List<String> listNo = new ArrayList<String>();
			if (lisNobGcbs.size() > 0) {
				// 将小区名字放进list里面
				for (Iterator<NobGcb> iterator = lisNobGcbs.iterator(); iterator.hasNext();) {
					NobGcb nobGcb = (NobGcb) iterator.next();
					if (!listNo.contains(nobGcb.getCellname())) {// 小区名放进去
						listNo.add(nobGcb.getCellname());
					}

				}

			}
			if (listNo.size() > 0) {
				for (int i = 0; i < listNo.size(); i++) {
					String cellNo = listNo.get(i);
					paramMap.put("cellname", cellNo);
					if (i == 0) {
						List<NobGcb> nobGcbs = nobGcbService.find(paramMap);
						NobGcb nobGcb = null;
						if (nobGcbs != null && nobGcbs.size() > 0) {
							nobGcb = nobGcbs.get(0);
							if (StringUtils.isNotBlank(nobGcb.getId())) {
								map.put("longitude", nobGcb.getLongitude());// 经度
								map.put("latitude", nobGcb.getLatitude());// 纬度
								map.put("tac", nobGcb.getTac());// TAC
								map.put("stationNo", nobGcb.getNodebid());// 基站号
								map.put("cellid", nobGcb.getCellid());// cellid
								map.put("fqpoint", nobGcb.getFqpoint());// fqpoint
								map.put("pci", nobGcb.getPci());// pci
								map.put("txgg", nobGcb.getTxgg());// 天线挂高
								map.put("rspower", nobGcb.getRspower());// RsPower
								map.put("fxj", nobGcb.getFxj());// 方向角
								map.put("zxqj", nobGcb.getZxqj());// 总下倾角
								map.put("dxqj", nobGcb.getDxqj());// 电下倾角
								map.put("jxxqj", nobGcb.getJxxqj());// 机械下倾角
							}
						}
						List<NobAssessment> nobAssessments = nobAssessmentService.find(paramMap);
						if (nobAssessments != null && nobAssessments.size() > 0) {
							NobAssessment nobAssessment = nobAssessments.get(0);
							if (StringUtils.isNotBlank(nobAssessment.getId())) {
								// 小区1
								map.put("wireless_RSRP", nobAssessment.getWireless_RSRP());// 选线信号
								map.put("wireless_SINR", nobAssessment.getWireless_SINR());
								map.put("a_SuccessRatio", nobAssessment.getA_SuccessRatio());// 附着性能
								map.put("c_ReElectionRatio", nobAssessment.getC_ReElectionRatio());// 重选性能
								map.put("r_ReElectionRatio", nobAssessment.getR_ReElectionRatio());// rrc链接冲功率
								map.put("p_Delay", nobAssessment.getP_Delay());// //ping性能 ping时延
								map.put("p_SuccessRadio", nobAssessment.getP_SuccessRadio());// -Ping成功率
								map.put("macUp", nobAssessment.getMacUp());// //mac -Ping成功率
								map.put("macDown", nobAssessment.getMacDown());// -Ping成功率

								map.put("tacs", nobAssessment.getTac());
								map.put("cellids", nobAssessment.getCellId());
								map.put("pcis", nobAssessment.getPci());

								map.put("longitudes", nullToEmpty(nobAssessment.getLongitude()));// 经度
								map.put("latitudes", nullToEmpty(nobAssessment.getLatitude()));// 纬度
							}
							ComparedMethod(map, nobGcb == null ? new NobGcb() : nobGcb, nobAssessment);
						}
					}
					if (i == 1) {
						NobGcb nobGcb = null;
						List<NobGcb> nobGcbs = nobGcbService.find(paramMap);
						if (nobGcbs != null && nobGcbs.size() > 0) {
							nobGcb = nobGcbs.get(0);
							if (StringUtils.isNotBlank(nobGcb.getId())) {
								map.put("longitude2", nobGcb.getLongitude());// 经度
								map.put("latitude2", nobGcb.getLatitude());// 纬度
								map.put("tac2", nobGcb.getTac());// TAC
								map.put("stationNo2", nobGcb.getNodebid());// 基站号
								map.put("cellid2", nobGcb.getCellid());// cellid
								map.put("fqpoint2", nobGcb.getFqpoint());// fqpoint
								map.put("pci2", nobGcb.getPci());// pci
								map.put("txgg2", nobGcb.getTxgg());// 天线挂高
								map.put("rspower2", nobGcb.getRspower());// RsPower
								map.put("fxj2", nobGcb.getFxj());// 方向角
								map.put("zxqj2", nobGcb.getZxqj());// 总下倾角
								map.put("dxqj2", nobGcb.getDxqj());// 电下倾角
								map.put("jxxqj2", nobGcb.getJxxqj());// 机械下倾角
							}
						}

						List<NobAssessment> nobAssessments = nobAssessmentService.find(paramMap);
						if (nobAssessments != null && nobAssessments.size() > 0) {
							NobAssessment nobAssessment = nobAssessments.get(0);
							if (StringUtils.isNotBlank(nobAssessment.getId())) {
								// 小区1
								map.put("wireless_RSRP2", nobAssessment.getWireless_RSRP());// 选线信号
								map.put("wireless_SINR2", nobAssessment.getWireless_SINR());
								map.put("a_SuccessRatio2", nobAssessment.getA_SuccessRatio());// 附着性能
								map.put("c_ReElectionRatio2", nobAssessment.getC_ReElectionRatio());// 重选性能
								map.put("r_ReElectionRatio2", nobAssessment.getR_ReElectionRatio());// rrc链接冲功率
								map.put("p_Delay2", nobAssessment.getP_Delay());// //ping性能 ping时延
								map.put("p_SuccessRadio2", nobAssessment.getP_SuccessRadio());// -Ping成功率
								map.put("macUp2", nobAssessment.getMacUp());// //mac -Ping成功率
								map.put("macDown2", nobAssessment.getMacDown());// -Ping成功率

								map.put("tacs2", nobAssessment.getTac());
								map.put("cellids2", nobAssessment.getCellId());
								map.put("pcis2", nobAssessment.getPci());
								map.put("longitudes2", nullToEmpty(nobAssessment.getLongitude()));// 经度
								map.put("latitudes2", nullToEmpty(nobAssessment.getLatitude()));// 纬度
							}
							ComparedMethod(map, nobGcb == null ? new NobGcb() : nobGcb, nobAssessment);
						}
					}
					if (i == 2) {
						NobGcb nobGcb = null;
						List<NobGcb> nobGcbs = nobGcbService.find(paramMap);
						if (nobGcbs != null && nobGcbs.size() > 0) {
							nobGcb = nobGcbs.get(0);
							if (StringUtils.isNotBlank(nobGcb.getId())) {
								map.put("longitude3", nobGcb.getLongitude());// 经度
								map.put("latitude3", nobGcb.getLatitude());// 纬度
								map.put("tac3", nobGcb.getTac());// TAC
								map.put("stationNo3", nobGcb.getNodebid());// 基站号
								map.put("cellid3", nobGcb.getCellid());// cellid
								map.put("fqpoint3", nobGcb.getFqpoint());// fqpoint
								map.put("pci3", nobGcb.getPci());// pci
								map.put("txgg3", nobGcb.getTxgg());// 天线挂高
								map.put("rspower3", nobGcb.getRspower());// RsPower
								map.put("fxj3", nobGcb.getFxj());// 方向角
								map.put("zxqj3", nobGcb.getZxqj());// 总下倾角
								map.put("dxqj3", nobGcb.getDxqj());// 电下倾角
								map.put("jxxqj3", nobGcb.getJxxqj());// 机械下倾角
							}
						}

						List<NobAssessment> nobAssessments = nobAssessmentService.find(paramMap);
						if (nobAssessments != null && nobAssessments.size() > 0) {
							NobAssessment nobAssessment = nobAssessments.get(0);
							if (StringUtils.isNotBlank(nobAssessment.getId())) {
								// 小区1
								map.put("wireless_RSRP3", nobAssessment.getWireless_RSRP());// 选线信号
								map.put("wireless_SINR3", nobAssessment.getWireless_SINR());
								map.put("a_SuccessRatio3", nobAssessment.getA_SuccessRatio());// 附着性能
								map.put("c_ReElectionRatio3", nobAssessment.getC_ReElectionRatio());// 重选性能
								map.put("r_ReElectionRatio3", nobAssessment.getR_ReElectionRatio());// rrc链接冲功率
								map.put("p_Delay3", nobAssessment.getP_Delay());// //ping性能 ping时延
								map.put("p_SuccessRadio3", nobAssessment.getP_SuccessRadio());// -Ping成功率
								map.put("macUp3", nobAssessment.getMacUp());// //mac -Ping成功率
								map.put("macDown3", nobAssessment.getMacDown());// -Ping成功率

								map.put("tacs3", nobAssessment.getTac());
								map.put("cellids3", nobAssessment.getCellId());
								map.put("pcis3", nobAssessment.getPci());
								map.put("longitudes3", nullToEmpty(nobAssessment.getLongitude()));// 经度
								map.put("latitudes3", nullToEmpty(nobAssessment.getLatitude()));// 纬度
							}
							ComparedMethod(map, nobGcb == null ? new NobGcb() : nobGcb, nobAssessment);
						}
					}
				}
			}

		} else {// 为空就输出一个空的文件
			map.put("title", "未传入站号、项目的id");// 标题
		}

		// 模板的路径
		File file = new File(nobitDocExcel);
		map.put("title", stationNo + "_" + map.get("jzname") + "_" + MyDateUtil.getNowDate("yyyyMMddHHmmss"));
		try {
			exportReportShanghaiAppExcel(projId, stationNo, map, file.getAbsolutePath(), response, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 新上海报告导出
	 */
	public void exportReportShanghaiAppExcel(Integer projId, String stationNo, Map<String, Object> map, String path,
			HttpServletResponse response, HttpSession session) throws Exception {
		try {
			// 创建一个工作薄WorkbookFactory.create(fis);
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)));
			HSSFSheet sheetPic;
			HSSFSheet sheetWeb = null;

			/***
			 * 图片填充
			 */
			sheetPic = workbook.getSheetAt(2);// 图片填充
			HSSFPatriarch patriarch = sheetPic.createDrawingPatriarch();
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("projId", projId);
			paramMap.put("nodebid", stationNo);
			List<NobRoadInfo> nobRoadInfos = nobRoadInfoService.find(paramMap);
			if (nobRoadInfos.size() > 0) {
				NobRoadInfo nobRoadInfo = nobRoadInfos.get(0);
				// rsrp
				String rsrp = "";
				if (StringUtils.isNoneBlank(nobRoadInfo.getRsrpImage())) {// 现在这样操作 在写excel的时候就只需要判断为不为空就可以了
					File file = new File(filesPath + nobRoadInfo.getRsrpImage());
					if (file.exists()) {
						rsrp = file.getAbsolutePath();
					}
				}
				// sinr
				String sinr = "";
				if (StringUtils.isNoneBlank(nobRoadInfo.getSinrImage())) {// 现在这样操作 在写excel的时候就只需要判断为不为空就可以了
					File file = new File(filesPath + nobRoadInfo.getSinrImage());
					if (file.exists()) {
						sinr = file.getAbsolutePath();
					}
				}
				// ping
				String ping = "";
				// rsrp
				if (StringUtils.isNoneBlank(nobRoadInfo.getPciImage())) {// 现在这样操作 在写excel的时候就只需要判断为不为空就可以了
					File file = new File(filesPath + nobRoadInfo.getPciImage());
					if (file.exists()) {
						ping = file.getAbsolutePath();
					}
				}
				// ping动态
				String picThresholdImage = "";
				// rsrp
				if (StringUtils.isNoneBlank(nobRoadInfo.getPicThresholdImage())) {
					File file = new File(filesPath + nobRoadInfo.getPicThresholdImage());
					if (file.exists()) {
						picThresholdImage = file.getAbsolutePath();
					}
				}
				
				// ping动态
				String sinrThresholdImage = "";
				// rsrp
				if (StringUtils.isNoneBlank(nobRoadInfo.getSinrThresholdImage())) {
					File file = new File(filesPath + nobRoadInfo.getSinrThresholdImage());
					if (file.exists()) {
						sinrThresholdImage = file.getAbsolutePath();
					}
				}
				String rsrpThresholdImage = "";
				// rsrp
				if (StringUtils.isNoneBlank(nobRoadInfo.getRsrpThresholdImage())) {
					File file = new File(filesPath + nobRoadInfo.getRsrpThresholdImage());
					if (file.exists()) {
						rsrpThresholdImage = file.getAbsolutePath();
					}
				}
				
				
				
				// 图片填充
				// rsrp
				if (StringUtils.isNoneBlank(rsrp)) {
					MyUtil.createExcelPic(workbook, patriarch, rsrp, (short) 0, 7, (short) 5, 26);
				}
				// picThresholdImage
				if (StringUtils.isNoneBlank(picThresholdImage)) {
					MyUtil.createExcelPic(workbook, patriarch, picThresholdImage, (short) 0, 27, (short) 5, 48);
				}
				// sinr
				if (StringUtils.isNoneBlank(sinr)) {
					MyUtil.createExcelPic(workbook, patriarch, sinr, (short) 0, 49, (short) 5, 70);
				}
				// ping
				if (StringUtils.isNoneBlank(ping)) {
					MyUtil.createExcelPic(workbook, patriarch, ping, (short) 0, 71, (short) 5, 92);
				}
				if (StringUtils.isNoneBlank(sinrThresholdImage)) {
					MyUtil.createExcelPic(workbook, patriarch, sinrThresholdImage, (short) 0, 93, (short) 5, 114);
				}
				if (StringUtils.isNoneBlank(rsrpThresholdImage)) {
					MyUtil.createExcelPic(workbook, patriarch, rsrpThresholdImage, (short) 0, 115, (short) 5, 136);
				}
			}

			sheetWeb = workbook.getSheetAt(1);// 得到excel的第一页 默认从0开始

			HSSFCell cell;
			HSSFRow row;

			// 获取行 并对行填充数据
			row = sheetWeb.getRow(0);
			cell = row.getCell(0);
			cell.setCellValue(String.valueOf(map.get("title")));

			row = sheetWeb.getRow(3);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("plantestengineer")));
			cell = row.getCell(10);
			cell.setCellValue(String.valueOf(map.get("plantestphone")));

			row = sheetWeb.getRow(4);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("planbackendengineer")));
			cell = row.getCell(10);
			cell.setCellValue(String.valueOf(map.get("planbackendphone")));

			row = sheetWeb.getRow(6);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("testTime")));

			// 开始
			row = sheetWeb.getRow(21);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("longitude")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("longitude2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("longitude3")));

			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("longitudes")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("longitudes2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("longitudes3")));
			cell = row.getCell(10);
			cell.setCellValue(String.valueOf(map.get("flag1")));

			row = sheetWeb.getRow(22);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("latitude")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("latitude2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("latitude3")));

			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("latitudes")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("latitudes2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("latitudes3")));
			cell = row.getCell(10);
			cell.setCellValue(String.valueOf(map.get("flag2")));

			row = sheetWeb.getRow(23);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("tac")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("tac2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("tac3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("tacs")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("tacs2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("tacs3")));
			cell = row.getCell(10);
			cell.setCellValue(String.valueOf(map.get("flag3")));

			row = sheetWeb.getRow(24);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("stationNo")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("stationNo2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("stationNo3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("stationNo")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("stationNo2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("stationNo3")));

			row = sheetWeb.getRow(25);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("cellid")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("cellid2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("cellid3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("cellids")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("cellids2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("cellids3")));
			cell = row.getCell(10);
			cell.setCellValue(String.valueOf(map.get("flag4")));

			row = sheetWeb.getRow(26);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("fqpoint")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("fqpoint2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("fqpoint3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("fqpoint")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("fqpoint2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("fqpoint3")));

			row = sheetWeb.getRow(27);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("pci")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("pci2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("pci3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("pcis")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("pcis2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("pcis3")));
			cell = row.getCell(10);
			cell.setCellValue(String.valueOf(map.get("flag5")));

			row = sheetWeb.getRow(29);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("rspower")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("rspower2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("rspower3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("rspower")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("rspower2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("rspower3")));

			row = sheetWeb.getRow(30);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("txgg")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("txgg2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("txgg3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("txgg")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("txgg2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("txgg3")));

			row = sheetWeb.getRow(31);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("fxj")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("fxj2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("fxj3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("fxj")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("fxj2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("fxj3")));

			row = sheetWeb.getRow(32);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("zxqj")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("zxqj2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("zxqj3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("zxqj")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("zxqj2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("zxqj3")));

			row = sheetWeb.getRow(33);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("dxqj")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("dxqj2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("dxqj3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("dxqj")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("dxqj2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("dxqj3")));

			row = sheetWeb.getRow(34);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("jxxqj")));
			cell = row.getCell(5);
			cell.setCellValue(String.valueOf(map.get("jxxqj2")));
			cell = row.getCell(6);
			cell.setCellValue(String.valueOf(map.get("jxxqj3")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("jxxqj")));
			cell = row.getCell(8);
			cell.setCellValue(String.valueOf(map.get("jxxqj2")));
			cell = row.getCell(9);
			cell.setCellValue(String.valueOf(map.get("jxxqj3")));

			row = sheetWeb.getRow(41);
			cell = row.getCell(4);
			cell.setCellValue(String.valueOf(map.get("wireless_RSRP")));
			cell = row.getCell(7);
			cell.setCellValue(String.valueOf(map.get("wireless_SINR")));
			cell = row.getCell(10);
			cell.setCellValue(String.valueOf(map.get("wireless_RSRP2")));
			cell = row.getCell(13);
			cell.setCellValue(String.valueOf(map.get("wireless_SINR2")));
			cell = row.getCell(16);
			cell.setCellValue(String.valueOf(map.get("wireless_RSRP3")));
			cell = row.getCell(19);
			cell.setCellValue(String.valueOf(map.get("wireless_SINR3")));

			String a_SuccessRatio = (String) map.get("a_SuccessRatio");
			if (StringUtils.isNotBlank(a_SuccessRatio)) {
				a_SuccessRatio = a_SuccessRatio + "%";
			}
			String a_SuccessRatio2 = (String) map.get("a_SuccessRatio2");
			if (StringUtils.isNotBlank(a_SuccessRatio2)) {
				a_SuccessRatio2 = a_SuccessRatio2 + "%";
			}
			String a_SuccessRatio3 = (String) map.get("a_SuccessRatio3");
			if (StringUtils.isNotBlank(a_SuccessRatio3)) {
				a_SuccessRatio3 = a_SuccessRatio3 + "%";
			}
			row = sheetWeb.getRow(44);
			cell = row.getCell(4);
			cell.setCellValue(a_SuccessRatio);
			cell = row.getCell(10);
			cell.setCellValue(a_SuccessRatio2);
			cell = row.getCell(16);
			cell.setCellValue(a_SuccessRatio3);

			String c_ReElectionRatio = (String) map.get("c_ReElectionRatio");
			if (StringUtils.isNotBlank(c_ReElectionRatio)) {
				c_ReElectionRatio = c_ReElectionRatio + "%";
			}
			String c_ReElectionRatio2 = (String) map.get("c_ReElectionRatio2");
			if (StringUtils.isNotBlank(c_ReElectionRatio2)) {
				c_ReElectionRatio2 = c_ReElectionRatio2 + "%";
			}
			String c_ReElectionRatio3 = (String) map.get("c_ReElectionRatio3");
			if (StringUtils.isNotBlank(c_ReElectionRatio3)) {
				c_ReElectionRatio3 = c_ReElectionRatio3 + "%";
			}
			row = sheetWeb.getRow(45);
			cell = row.getCell(4);
			cell.setCellValue(c_ReElectionRatio);
			cell = row.getCell(10);
			cell.setCellValue(c_ReElectionRatio2);
			cell = row.getCell(16);
			cell.setCellValue(c_ReElectionRatio3);

			String r_ReElectionRatio = (String) map.get("r_ReElectionRatio");
			if (StringUtils.isNotBlank(r_ReElectionRatio)) {
				r_ReElectionRatio = r_ReElectionRatio + "%";
			}
			String r_ReElectionRatio2 = (String) map.get("r_ReElectionRatio2");
			if (StringUtils.isNotBlank(r_ReElectionRatio2)) {
				r_ReElectionRatio2 = r_ReElectionRatio2 + "%";
			}
			String r_ReElectionRatio3 = (String) map.get("r_ReElectionRatio3");
			if (StringUtils.isNotBlank(r_ReElectionRatio3)) {
				r_ReElectionRatio3 = r_ReElectionRatio3 + "%";
			}
			row = sheetWeb.getRow(46);
			cell = row.getCell(4);
			cell.setCellValue(r_ReElectionRatio);
			cell = row.getCell(10);
			cell.setCellValue(r_ReElectionRatio2);
			cell = row.getCell(16);
			cell.setCellValue(r_ReElectionRatio3);

			String p_Delay2 = (String) map.get("p_Delay2");
			if (StringUtils.isNotBlank(p_Delay2)) {
				p_Delay2 = p_Delay2 + "ms";
			}
			String p_Delay = (String) map.get("p_Delay");
			if (StringUtils.isNotBlank(p_Delay)) {
				p_Delay = p_Delay + "ms";
			}
			String p_Delay3 = (String) map.get("p_Delay3");
			if (StringUtils.isNotBlank(p_Delay3)) {
				p_Delay3 = p_Delay3 + "ms";
			}
			row = sheetWeb.getRow(47);
			cell = row.getCell(4);
			cell.setCellValue(p_Delay);
			cell = row.getCell(10);
			cell.setCellValue(p_Delay2);
			cell = row.getCell(16);
			cell.setCellValue(p_Delay3);

			String p_SuccessRadio = (String) map.get("p_SuccessRadio");
			if (StringUtils.isNotBlank(p_SuccessRadio)) {
				p_SuccessRadio = p_SuccessRadio + "%";
			}
			String p_SuccessRadio2 = (String) map.get("p_SuccessRadio2");
			if (StringUtils.isNotBlank(p_SuccessRadio2)) {
				p_SuccessRadio2 = p_SuccessRadio2 + "%";
			}
			String p_SuccessRadio3 = (String) map.get("p_SuccessRadio3");
			if (StringUtils.isNotBlank(p_SuccessRadio3)) {
				p_SuccessRadio3 = p_SuccessRadio3 + "%";
			}
			row = sheetWeb.getRow(48);
			cell = row.getCell(4);
			cell.setCellValue(p_SuccessRadio);
			cell = row.getCell(10);
			cell.setCellValue(p_SuccessRadio2);
			cell = row.getCell(16);
			cell.setCellValue(p_SuccessRadio3);

			String macUp = (String) map.get("macUp");
			if (StringUtils.isNotBlank(macUp)) {
				macUp = macUp + "kbps";
			}
			String macUp2 = (String) map.get("macUp2");
			if (StringUtils.isNotBlank(macUp2)) {
				macUp2 = macUp2 + "kbps";
			}
			String macUp3 = (String) map.get("macUp3");
			if (StringUtils.isNotBlank(macUp3)) {
				macUp3 = macUp3 + "kbps";
			}
			row = sheetWeb.getRow(49);
			cell = row.getCell(4);
			cell.setCellValue(macUp);
			cell = row.getCell(10);
			cell.setCellValue(macUp2);
			cell = row.getCell(16);
			cell.setCellValue(macUp3);

			String macDown = (String) map.get("macDown");
			if (StringUtils.isNotBlank(macDown)) {
				macDown = macDown + "kbps";
			}
			String macDown2 = (String) map.get("macDown2");
			if (StringUtils.isNotBlank(macDown2)) {
				macDown2 = macDown2 + "kbps";
			}
			String macDown3 = (String) map.get("macDown3");
			if (StringUtils.isNotBlank(macDown3)) {
				macDown3 = macDown3 + "kbps";
			}
			row = sheetWeb.getRow(50);
			cell = row.getCell(4);
			cell.setCellValue(macDown);
			cell = row.getCell(10);
			cell.setCellValue(macDown2);
			cell = row.getCell(16);
			cell.setCellValue(macDown3);

			OutputStream out = response.getOutputStream();
			// String fileNameStr=new SimpleDateFormat("yyyy-MM-dd").format(new
			// Date())+"_"+map.get("stationNo")+"_"+map.get("jzname");
			String fileNameStr = (String) map.get("title");
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition",
					"attachment;filename=\"" + new String((fileNameStr + ".xls").getBytes("GBK"), "ISO8859-1") + "\"");
			workbook.write(out);

		} catch (IOException io) {

		}
	}

	private void ComparedMethod(Map<String, Object> map, NobGcb nobGcb, NobAssessment nobAssessment) {
		// 经度比较
		if (StringUtils.isNotBlank(nobAssessment.getLongitude()) && StringUtils.isNotBlank(nobAssessment.getLatitude())
				&& StringUtils.isNotBlank(nobGcb.getLatitude()) && StringUtils.isNotBlank(nobGcb.getLongitude())) {
			try {
				double d = MyUtil.getDistance(Double.valueOf(nobGcb.getLatitude()),
						Double.valueOf(nobGcb.getLongitude()), Double.valueOf(nobAssessment.getLatitude()),
						Double.valueOf(nobAssessment.getLongitude()));
				if (("start").equals((String) map.get("flag1"))) {
					map.put("flag1", String.format("%.2f", d) + "米");
					map.put("flag2", String.format("%.2f", d) + "米");
				} else {
					map.put("flag1", map.get("flag1") + "/" + String.format("%.2f", d) + "米");
					map.put("flag2", map.get("flag2") + "/" + String.format("%.2f", d) + "米");
				}

			} catch (Exception e) {
			}
		} else {
			if (StringUtils.isBlank(nobAssessment.getLongitude()) && StringUtils.isBlank(nobAssessment.getLatitude())
					&& StringUtils.isBlank(nobGcb.getLatitude()) && StringUtils.isBlank(nobGcb.getLongitude())) {
				if (("start").equals((String) map.get("flag1"))) {
					map.put("flag1", "一致");
					map.put("flag2", "一致");
				} else {
					map.put("flag1", map.get("flag1") + "/" + "一致");
					map.put("flag2", map.get("flag2") + "/" + "一致");
				}
			} else {
				if (("start").equals((String) map.get("flag1"))) {
					map.put("flag1", "不一致");
					map.put("flag2", "不一致");
				} else {
					map.put("flag1", map.get("flag1") + "/" + "不一致");
					map.put("flag2", map.get("flag2") + "/" + "不一致");
				}
			}
		}

		// tac
		if (StringUtils.isBlank(nobGcb.getTac())) {
			if (StringUtils.isBlank(nobAssessment.getTac())) {
				map.put("flag3", "一致");
			}
		} else {
			if (nobGcb.getTac().equals(nobAssessment.getTac())) {
				map.put("flag3", "一致");
			}
		}

		// cellid
		if (StringUtils.isBlank(nobGcb.getCellid())) {
			if (StringUtils.isBlank(nobAssessment.getCellId())) {
				map.put("flag4", "一致");
			}
		} else {
			if (nobGcb.getCellid().equals(nobAssessment.getCellId())) {
				map.put("flag4", "一致");
			}
		}

		// pci
		if (StringUtils.isBlank(nobGcb.getPci())) {
			if (StringUtils.isBlank(nobAssessment.getPci())) {
				map.put("flag5", "一致");
			}
		} else {
			if (nobGcb.getPci().equals(nobAssessment.getPci())) {
				map.put("flag5", "一致");
			}
		}
	}

	/**
	 * 获取图片的后缀类型
	 */
	public String getPictureType(String fileName) {
		String proType = fileName.substring(fileName.lastIndexOf(".") + 1);
		return proType;
	}

	public String nullToEmpty(String str) {
		if (StringUtils.isBlank(str)) {
			str = "";
		}
		return str;
	}

	private String upFile(MultipartFile file, String modelName) {
		return FileUtil.UpFile(file, filesPath, modelName);
	}
}
