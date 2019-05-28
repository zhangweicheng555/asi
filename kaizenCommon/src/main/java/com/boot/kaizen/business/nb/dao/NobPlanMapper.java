package com.boot.kaizen.business.nb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.boot.kaizen.business.nb.model.NobPlan;

@Mapper
public interface NobPlanMapper {
	
	int deleteByPrimaryKey(String planeid);

	int insertSelective(NobPlan record);

	NobPlan selectByPrimaryKey(String planeid);

	int updateByPrimaryKeySelective(NobPlan record);
	
	List<NobPlan> find(@Param("map") Map<String, Object> map);

}