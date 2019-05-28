package com.boot.kaizen.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.kaizen.dao.SysRoleUserDao;
import com.boot.kaizen.model.SysRoleUser;
import com.boot.kaizen.service.SysRoleUserService;

@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {

	@Autowired
	private SysRoleUserDao roleUserDao;

	@Override
	public void delete(Long roleId) {
		roleUserDao.delete(roleId);
	}

	@Override
	public void batchInsert(List<SysRoleUser> roleUsers) {
		roleUserDao.batchInsert(roleUsers);
	}

	@Override
	public void deleteBatch(Long[] userIds) {
		roleUserDao.deleteBatch(userIds);
	}

	@Override
	public void deleteByProjIds(Long[] projIds) {
		roleUserDao.deleteByProjIds(projIds);
	}

}
