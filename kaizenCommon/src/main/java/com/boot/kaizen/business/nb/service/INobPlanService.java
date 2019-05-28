package com.boot.kaizen.business.nb.service;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import com.boot.kaizen.business.nb.model.NobPlan;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.util.JsonMsgUtil;

/**
 * 自动单验拨测表业务接口
 * 
 * @author weichengz
 * @date 2019年2月17日 上午8:32:30
 */
public interface INobPlanService {

	int deleteByPrimaryKey(String id);

	int insertSelective(NobPlan record);

	NobPlan selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobPlan record);

	/**
	 * 
	 * @Description: 条件查询
	 * @author weichengz
	 * @date 2019年2月17日 上午8:31:42
	 */
	List<NobPlan> find(Map<String, Object> map);

	List<NobPlan> query(Map<String, Object> map);

	JsonMsgUtil edit(NobPlan NobPlan, LoginUser loginUser);

	JsonMsgUtil findById(String id);

	NobPlan queryById(String id);

	JsonMsgUtil delete(String ids);

	JsonMsgUtil upload(MultipartFile file, LoginUser loginUser);

	/**
	 * 查询本项目下的用户列表
	* @Description: TODO
	* @author weichengz
	* @date 2019年4月23日 上午10:02:23
	 */
	JsonMsgUtil queryLoginUser(Long projId);

}
