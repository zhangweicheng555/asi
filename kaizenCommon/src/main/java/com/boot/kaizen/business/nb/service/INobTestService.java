package com.boot.kaizen.business.nb.service;

import java.util.List;
import java.util.Map;
import com.boot.kaizen.business.nb.model.NobTest;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.util.JsonMsgUtil;

/**
 * 自动单验拨测表业务接口
 * 
 * @author weichengz
 * @date 2019年2月17日 上午8:32:30
 */
public interface INobTestService {

	int deleteByPrimaryKey(String id);

	int insertSelective(NobTest record);

	NobTest selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobTest record);

	/**
	 * 
	 * @Description: 条件查询
	 * @author weichengz
	 * @date 2019年2月17日 上午8:31:42
	 */
	List<NobTest> find(Map<String, Object> map);

	List<NobTest> query(Map<String, Object> map);

	JsonMsgUtil edit(NobTest NobTest, LoginUser loginUser);

	JsonMsgUtil findById(String id);

	NobTest queryById(String id);

	JsonMsgUtil delete(String ids);
}
