package com.boot.kaizen.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boot.kaizen.model.SysProjectRoleRelation;

@Mapper
public interface SysProjectRoleRelationDao {

	void batchInsert(@Param("list") List<SysProjectRoleRelation> relations);

	void deleteByRoleAndProId(@Param("roleId") Long roleId);

	void deleteByProIds(@Param("arrayIds") Long[] array);
}
