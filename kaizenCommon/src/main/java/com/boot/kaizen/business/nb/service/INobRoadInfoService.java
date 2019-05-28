package com.boot.kaizen.business.nb.service;

import java.util.List;
import java.util.Map;
import com.boot.kaizen.business.nb.model.NobRoadInfo;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.util.JsonMsgUtil;

/**
 * 自动单验拨测表业务接口
 * 
 * @author weichengz
 * @date 2019年2月17日 上午8:32:30
 */
public interface INobRoadInfoService {

	int deleteByPrimaryKey(String id);

	int insertSelective(NobRoadInfo record);

	NobRoadInfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobRoadInfo record);

	/**
	 * 
	 * @Description: 条件查询
	 * @author weichengz
	 * @date 2019年2月17日 上午8:31:42
	 */
	List<NobRoadInfo> find(Map<String, Object> map);

	List<NobRoadInfo> query(Map<String, Object> map);

	JsonMsgUtil edit(NobRoadInfo model, LoginUser loginUser);
	
	JsonMsgUtil editApp(NobRoadInfo model, Integer projId);

	JsonMsgUtil findById(String id);

	NobRoadInfo queryById(String id);

	JsonMsgUtil delete(String ids);


}
