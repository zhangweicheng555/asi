package com.boot.kaizen.dao.log;

import org.apache.ibatis.annotations.Mapper;

import com.boot.kaizen.model.log.OperateLog;

@Mapper
public interface SysOperateLogDao {

	/**
	 * 
	 * @Description: c操作日志信息保存
	 * @author weichengz
	 * @date 2018年11月25日 上午2:50:52
	 */
	public void save(OperateLog operateLog);

}
