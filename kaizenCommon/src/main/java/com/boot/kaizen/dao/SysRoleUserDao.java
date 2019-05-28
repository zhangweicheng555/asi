package com.boot.kaizen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boot.kaizen.model.SysRoleUser;

@Mapper
public interface SysRoleUserDao {

	void delete(@Param("roleId") Long roleId);
	
	void batchInsert(@Param("list") List<SysRoleUser> roleUsers);

	void deleteBatch(@Param("userIds") Long[] userIds);

	void deleteByProjIds(@Param("projIds") Long[] projIds);

}
