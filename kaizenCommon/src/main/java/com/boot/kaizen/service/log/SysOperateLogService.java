package com.boot.kaizen.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.kaizen.dao.log.SysOperateLogDao;
import com.boot.kaizen.model.log.OperateLog;

@Service
class SysOperateLogService implements ISysOperateLogService {

	@Autowired
	private SysOperateLogDao operateLogDao;

	@Override
	public void save(OperateLog operateLog) {
		operateLogDao.save(operateLog);
	}

}
