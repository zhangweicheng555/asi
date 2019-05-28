package com.boot.kaizen.business.nb.service;

import java.util.List;
import java.util.Map;
import com.boot.kaizen.business.nb.model.NobCheck;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.util.JsonMsgUtil;

/**
 * 自动单验拨测表业务接口
 * 
 * @author weichengz
 * @date 2019年2月17日 上午8:32:30
 */
public interface INobCheckService {

	int deleteByPrimaryKey(String id);

	int insertSelective(NobCheck record);

	NobCheck selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobCheck record);

	/**
	 * 
	 * @Description: 条件查询
	 * @author weichengz
	 * @date 2019年2月17日 上午8:31:42
	 */
	List<NobCheck> find(Map<String, Object> map);

	List<NobCheck> query(Map<String, Object> map);

	JsonMsgUtil edit(NobCheck model, LoginUser loginUser);

	JsonMsgUtil findById(String id);

	NobCheck queryById(String id);

	JsonMsgUtil delete(String ids);


}
