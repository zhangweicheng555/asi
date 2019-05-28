package com.boot.kaizen.business.nb.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boot.kaizen.business.nb.dao.NobParamcheckMapper;
import com.boot.kaizen.business.nb.model.NobParamcheck;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.util.JsonMsgUtil;
import com.boot.kaizen.util.MyUtil;

/**
 * 自动单验拨测表业务实现
 * 
 * @author weichengz
 * @date 2019年2月17日 上午8:33:29
 */
@Service
public class NobParameterService implements INobParameterService {

	@Autowired
	private NobParamcheckMapper nobParamcheckMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return nobParamcheckMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(NobParamcheck record) {
		return nobParamcheckMapper.insertSelective(record);
	}

	@Override
	public NobParamcheck selectByPrimaryKey(String id) {
		return nobParamcheckMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(NobParamcheck record) {
		return nobParamcheckMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<NobParamcheck> find(Map<String, Object> map) {
		return nobParamcheckMapper.find(map);
	}

	@Override
	public List<NobParamcheck> query(Map<String, Object> map) {
		return find(map);
	}

	@Override
	public JsonMsgUtil edit(NobParamcheck model, LoginUser loginUser) {
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
	public void editApp(NobParamcheck model) {
		model.setId(MyUtil.getUuid());
		model.setCreateTime(new Date());
		insertSelective(model);
	}

	@Override
	public JsonMsgUtil findById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new IllegalArgumentException("数据id不能为空");
		}
		NobParamcheck model = selectByPrimaryKey(id);
		if (model == null) {
			throw new IllegalArgumentException("查询的数据不存在");
		}
		return new JsonMsgUtil(true, "操作成功", model);
	}

	@Override
	public NobParamcheck queryById(String id) {
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
			NobParamcheck model = selectByPrimaryKey(id);
			if (model != null) {
				deleteByPrimaryKey(id);
			}
		}
		return new JsonMsgUtil(true, "删除成功:共删除【" + idsArray.length + "】条记录", null);
	}

}
