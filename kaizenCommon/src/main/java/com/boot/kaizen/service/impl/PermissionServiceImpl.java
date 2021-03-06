package com.boot.kaizen.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boot.kaizen.dao.PermissionDao;
import com.boot.kaizen.entity.ZtreeModel;
import com.boot.kaizen.model.Permission;
import com.boot.kaizen.service.PermissionService;
import com.boot.kaizen.service.SysRolePermissionService;
import com.boot.kaizen.util.JsonMsgUtil;

@Service
public class PermissionServiceImpl implements PermissionService {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private SysRolePermissionService rolePermissionService;
	
	@Override
	public void save(Permission permission) {
		permissionDao.save(permission);

		log.debug("新增菜单{}", permission.getName());
	}

	@Override
	public void update(Permission permission) {
		permissionDao.update(permission);
	}

	@Override
	@Transactional
	public JsonMsgUtil delete(Long id) {
		JsonMsgUtil j=new JsonMsgUtil(false);
		try {
			//删除资源与角色的关系
			rolePermissionService.deleteByPermissionId(id);
			permissionDao.delete(id);
			j=new JsonMsgUtil(true, "操作成功", "");
		} catch (Exception e) {
			j.setMsg("删除操作失败");
		}
		return j;
	}

	@Override
	public JsonMsgUtil edit(Permission permission) {
		JsonMsgUtil j = new JsonMsgUtil(false);
		try {
			if (permission.getId() != null) {// edit
				permissionDao.update(permission);
				j = new JsonMsgUtil(true, "添加成功", "");
			} else {
				permissionDao.save(permission);
				j = new JsonMsgUtil(true, "添加成功", "");
			}
		} catch (Exception e) {
			j.setMsg("添加操作失败");
			e.printStackTrace();
		}
		return j;
	}

	@Override
	public List<ZtreeModel> find(List<Long> ids) {
		
		List<ZtreeModel> ztreeModels=new ArrayList<ZtreeModel>();
		List<Permission> permissions = permissionDao.listAll();
		if (permissions != null && permissions.size()>0) {
			for (Permission permission : permissions) {
				ZtreeModel ztreeModel=null;
				if (ids.contains(permission.getId())) {
					ztreeModel=new ZtreeModel(permission.getId(), permission.getParentId(), permission.getName(),true);
				}else {
					ztreeModel=new ZtreeModel(permission.getId(), permission.getParentId(), permission.getName());
				}
				ztreeModels.add(ztreeModel);
			}
		}
		return ztreeModels;
	}

	
	
	@Override
	public List<Permission> queryByUserIdAndProjId(String username, Long projId) {
		return permissionDao.queryByUserIdAndProjId(username,projId);
	}


}
