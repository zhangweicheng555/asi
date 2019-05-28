package com.boot.kaizen.business.nb.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.boot.kaizen.business.nb.model.NobGcb;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.util.JsonMsgUtil;

/**
 * 自动单验拨测表业务接口
 * 
 * @author weichengz
 * @date 2019年2月17日 上午8:32:30
 */
public interface INobGcbService {

	int deleteByPrimaryKey(String id);

	int insertSelective(NobGcb record);

	NobGcb selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobGcb record);

	/**
	 * 
	 * @Description: 条件查询
	 * @author weichengz
	 * @date 2019年2月17日 上午8:31:42
	 */
	List<NobGcb> find(Map<String, Object> map);

	List<NobGcb> query(Map<String, Object> map);

	JsonMsgUtil edit(NobGcb NobGcb, LoginUser loginUser);

	JsonMsgUtil findById(String id);

	NobGcb queryById(String id);

	JsonMsgUtil delete(String ids);

	JsonMsgUtil upload(MultipartFile file, LoginUser loginUser);

}
