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
import com.boot.kaizen.business.nb.dao.NobGcbMapper;
import com.boot.kaizen.business.nb.model.NobGcb;
import com.boot.kaizen.entity.LoginUser;
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
public class NobGcbService implements INobGcbService {

	@Autowired
	private NobGcbMapper nobGcbMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return nobGcbMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(NobGcb record) {
		return nobGcbMapper.insertSelective(record);
	}

	@Override
	public NobGcb selectByPrimaryKey(String id) {
		return nobGcbMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(NobGcb record) {
		return nobGcbMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<NobGcb> find(Map<String, Object> map) {
		return nobGcbMapper.find(map);
	}

	@Override
	public List<NobGcb> query(Map<String, Object> map) {
		return find(map);
	}

	@Override
	public JsonMsgUtil edit(NobGcb model, LoginUser loginUser) {
		if (loginUser == null) {
			throw new DisabledException("用户已过期，重新登陆");
		}
		if (loginUser.getProjId() == null) {
			throw new IllegalArgumentException("用户角色异常");
		}
		if (StringUtils.isNoneBlank(model.getId())) {// edit
			updateByPrimaryKeySelective(model);
		} else {// add
			model.setProjId(Integer.valueOf(loginUser.getProjId().toString()));
			model.setId(MyUtil.getUuid());
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
		NobGcb model = selectByPrimaryKey(id);
		if (model == null) {
			throw new IllegalArgumentException("查询的数据不存在");
		}
		return new JsonMsgUtil(true, "操作成功", model);
	}

	@Override
	public NobGcb queryById(String id) {
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
			NobGcb model = selectByPrimaryKey(id);
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
			if (sheet1.getRow(0).getLastCellNum() != 17) {
				msg = new JsonMsgUtil(false, "导入excel的列数要求为17列", null);
				return msg;
			}
			List<NobGcb> list = new ArrayList<NobGcb>();
			NobGcb model = null;
			for (int j = 1; j <= sheet1.getLastRowNum(); j++) {
				row = sheet1.getRow(j);
				if (row == null) {
					continue;
				}
				// 导入excel总行数记录
				int cell_index = 0;
				model = new NobGcb();
				// 基站号
				String enodebid = ExcelUtil.cell_string(row.getCell(cell_index++));
				if (StringUtils.isNoneBlank(enodebid)) {
					model.setNodebid(enodebid);
				} else {
					msg = new JsonMsgUtil(false, "站号不能为空", null);
					return msg;
				}

				String jzname = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setJzname(jzname);
				// 基站名称
				String cellid = ExcelUtil.cell_string(row.getCell(cell_index++));
				if (StringUtils.isNoneBlank(cellid)) {
					model.setCellid(cellid);
				} else {
					msg = new JsonMsgUtil(false, "小区号不能为空", null);
					return msg;
				}

				String cellname = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setCellname(cellname);
				String longitude = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setLongitude(longitude);
				String latitude = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setLatitude(latitude);
				String elevation = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setElevation(elevation);
				String tac = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setTac(tac);
				String fqpoint = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setFqpoint(fqpoint);
				String pci = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setPci(pci);
				String rspower = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setRspower(rspower);
				String txgg = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setTxgg(txgg);
				String fxj = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setFxj(fxj);
				String zxqj = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setZxqj(zxqj);

				String dxqj = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setDxqj(dxqj);

				String jxxqj = ExcelUtil.cell_string(row.getCell(cell_index++));
				model.setJxxqj(jxxqj);
				
				String finishflag = ExcelUtil.cell_string(row.getCell(cell_index++));
				if (StringUtils.isBlank(finishflag)) {
					msg = new JsonMsgUtil(false, "配置名要求不为空且配置名为配置项表里面的配置名", null);
					return msg;
				}
				model.setFinishflag(finishflag);
				// 添加进list里面
				list.add(model);
			}

			for (NobGcb modelM : list) {
				edit(modelM, loginUser);
			}
			msg = new JsonMsgUtil(true, "上传成功", null);
		} catch (Exception e) {
			msg = new JsonMsgUtil(false, e.getMessage(), null);
		}
		return msg;
	}

}
