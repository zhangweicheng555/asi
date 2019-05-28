package com.boot.kaizen.business.nb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.boot.kaizen.business.nb.dao.NobPlanMapper;
import com.boot.kaizen.business.nb.model.NobPlan;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.model.SysUser;
import com.boot.kaizen.service.SysRoleUserService;
import com.boot.kaizen.service.UserService;
import com.boot.kaizen.util.ExcelUtil;
import com.boot.kaizen.util.JsonMsgUtil;
import com.boot.kaizen.util.MyUtil;

/**
 * 自动单验拨测表业务实现
 * 
 * @author weichengz
 * @date 2019年2月17日 上午8:33:29
 */
@Service
public class NobPlanService implements INobPlanService {

	@Autowired
	private NobPlanMapper nobPlanMapper;
	@Autowired
	private UserService userService;

	@Override
	public int deleteByPrimaryKey(String id) {
		return nobPlanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(NobPlan record) {
		return nobPlanMapper.insertSelective(record);
	}

	@Override
	public NobPlan selectByPrimaryKey(String id) {
		return nobPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(NobPlan record) {
		return nobPlanMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<NobPlan> find(Map<String, Object> map) {
		return nobPlanMapper.find(map);
	}

	@Override
	public List<NobPlan> query(Map<String, Object> map) {
		 List<NobPlan> nobPlans = find(map);
		 if (nobPlans != null && nobPlans.size()>0) {
			for (NobPlan nobPlan : nobPlans) {
				String userid = nobPlan.getUserid();
				if (StringUtils.isNoneBlank(userid)) {
					SysUser sysUser = userService.selectById(Long.valueOf(userid));
					nobPlan.setUserid(sysUser.getUsername());
				}
			}
		}
		return nobPlans;
	}

	@Override
	public JsonMsgUtil edit(NobPlan model, LoginUser loginUser) {
		if (loginUser == null) {
			throw new DisabledException("用户已过期，重新登陆");
		}
		if (loginUser.getProjId() == null) {
			throw new IllegalArgumentException("用户角色异常");
		}
		if (StringUtils.isNoneBlank(model.getPlaneid())) {// edit
			updateByPrimaryKeySelective(model);
		} else {// add
			model.setProjId(Integer.valueOf(loginUser.getProjId().toString()));
			model.setPlaneid(MyUtil.getUuid());
			model.setCreateTime(new Date());
			insertSelective(model);
		}
		return new JsonMsgUtil(true, "编辑成功", model);
	}

	@Override
	public JsonMsgUtil findById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new IllegalArgumentException("数据id不能为空");
		}
		NobPlan model = selectByPrimaryKey(id);
		if (model == null) {
			throw new IllegalArgumentException("查询的数据不存在");
		}
		return new JsonMsgUtil(true, "操作成功", model);
	}

	@Override
	public NobPlan queryById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new IllegalArgumentException("数据id不能为空");
		}
		return selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public JsonMsgUtil delete(String ids) {
		if (StringUtils.isBlank(ids)) {
			throw new IllegalArgumentException("数据ids不能为空");
		}
		String[] idsArray = ids.trim().split(",");
		for (String id : idsArray) {
			// 查询数据
			NobPlan model = selectByPrimaryKey(id);
			if (model != null) {
				deleteByPrimaryKey(id);
			}
		}
		return new JsonMsgUtil(true, "删除成功:共删除【" + idsArray.length + "】条记录", null);
	}

	@Transactional
	@Override
	public JsonMsgUtil upload(MultipartFile file, LoginUser loginUser) {
		JsonMsgUtil msg = new JsonMsgUtil(false);
		try {
			// 导入
			HSSFWorkbook wbs = new HSSFWorkbook(file.getInputStream());
			HSSFSheet sheet1 = wbs.getSheetAt(0);
			HSSFRow row = null;
			if (sheet1.getRow(0).getLastCellNum() != 8) {
				msg = new JsonMsgUtil(false, "导入excel的列数要求为8列", null);
				return msg;
			}
			List<NobPlan> list = new ArrayList<NobPlan>();
			NobPlan model = null;
			for (int j = 1; j <= sheet1.getLastRowNum(); j++) {
				row = sheet1.getRow(j);
				if (row == null) {
					continue;
				}
				// 导入excel总行数记录
				int cell_index = 0;
				model = new NobPlan();
				// 基站号
				String nodebid = ExcelUtil.cell_string(row.getCell(cell_index++));
				if (StringUtils.isNoneBlank(nodebid)) {
					model.setNodebid(nodebid);
				} else {
					msg = new JsonMsgUtil(false, "站号不能为空", null);
					return msg;
				}

				// 基站名称
				String jzname = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setJzname(jzname);

				String userid = ExcelUtil.cell_string(row.getCell(cell_index++));
				SysUser queryUser = userService.queryUser(loginUser.getProjId(), userid);
				if (queryUser == null) {
					msg = new JsonMsgUtil(false, "不存在登陆账号", null);
					return msg;
				} else {
					model.setUserid(queryUser.getId().toString());
				}

				String plantestengineer = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setPlantestengineer(plantestengineer);
				String plantestphone = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setPlantestphone(plantestphone);

				String planbackendengineer = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setPlanbackendengineer(planbackendengineer);

				String planbackendphone = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setPlanbackendphone(planbackendphone);

				String planetesttime = ExcelUtil.cell_string(row.getCell(cell_index++));
				// 日期
				try {
					if (StringUtils.isNoneBlank(planetesttime)) {
						try {
							Integer.valueOf(planetesttime);// 验证日期是不是正确
							model.setPlanetesttime(ExcelUtil.dealDateToString(planetesttime));
						} catch (Exception e) {
							msg = new JsonMsgUtil(false, "测试日期格式不正确", null);
							return msg;
						}
					} else {
						msg = new JsonMsgUtil(false, "测试日期不能为空", null);
						return msg;
					}
				} catch (Exception e) {
					msg = new JsonMsgUtil(false, "测试日期格式不正确", null);
					return msg;
				}

				// 添加进list里面
				list.add(model);
			}

			for (NobPlan modelM : list) {
				edit(modelM, loginUser);
			}
			msg = new JsonMsgUtil(true, "上传成功", null);
		} catch (Exception e) {
			msg = new JsonMsgUtil(false, e.getMessage(), null);
		}
		return msg;
	}

	@Override
	public JsonMsgUtil queryLoginUser(Long projId) {
		return new JsonMsgUtil(true, "查询成功", userService.queryUserByProjId(projId));
	}

}
