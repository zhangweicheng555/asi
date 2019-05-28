package com.boot.kaizen.service;


public interface SysRolePermissionService {

	void deleteByRoleId(Long roleId);

	void deleteByPermissionId(Long id);

	void deleteByProjIds(Long[] projIds);
	
}
