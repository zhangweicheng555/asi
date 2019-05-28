package com.boot.kaizen.service;

import java.util.List;

import com.boot.kaizen.model.SysProjectRoleRelation;

public interface ProjectRoleRelationService {

	void batchInsert(List<SysProjectRoleRelation> relations);

	void deleteByRoleAndProId(Long roleId);

	void deleteByProIds(Long[] array);
}
