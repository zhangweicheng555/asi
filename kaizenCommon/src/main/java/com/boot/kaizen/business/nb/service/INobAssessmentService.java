package com.boot.kaizen.business.nb.service;

import java.util.List;
import java.util.Map;
import com.boot.kaizen.business.nb.model.NobAssessment;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.util.JsonMsgUtil;

/**
 * 达标评估测试结果业务接口
 * 
 * @author weichengz
 * @date 2019年2月17日 上午8:32:30
 */
public interface INobAssessmentService {

	int deleteByPrimaryKey(String id);

	int insertSelective(NobAssessment record);

	NobAssessment selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobAssessment record);

	/**
	 * 
	 * @Description: 条件查询
	 * @author weichengz
	 * @date 2019年2月17日 上午8:31:42
	 */
	List<NobAssessment> find(Map<String, Object> map);

	List<NobAssessment> query(Map<String, Object> map);

	JsonMsgUtil edit(NobAssessment model, LoginUser loginUser);

	void editApp(NobAssessment model);

	JsonMsgUtil findById(String id);

	NobAssessment queryById(String id);

	JsonMsgUtil delete(String ids);

}
