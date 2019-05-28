package com.boot.kaizen.business.nb.service;

import java.util.List;
import java.util.Map;
import com.boot.kaizen.business.nb.model.NobParamcheck;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.util.JsonMsgUtil;

/**
 * 自动单验拨测表业务接口
 * 
 * @author weichengz
 * @date 2019年2月17日 上午8:32:30
 */
public interface INobParameterService {

	int deleteByPrimaryKey(String id);

	int insertSelective(NobParamcheck record);

	NobParamcheck selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobParamcheck record);

	/**
	 * 
	 * @Description: 条件查询
	 * @author weichengz
	 * @date 2019年2月17日 上午8:31:42
	 */
	List<NobParamcheck> find(Map<String, Object> map);

	List<NobParamcheck> query(Map<String, Object> map);

	JsonMsgUtil edit(NobParamcheck model, LoginUser loginUser);

	JsonMsgUtil findById(String id);

	NobParamcheck queryById(String id);

	JsonMsgUtil delete(String ids);

	void editApp(NobParamcheck nobParamcheck);


}
