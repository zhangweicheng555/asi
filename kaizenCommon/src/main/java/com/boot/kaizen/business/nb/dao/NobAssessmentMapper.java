package com.boot.kaizen.business.nb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.boot.kaizen.business.nb.model.NobAssessment;

@Mapper
public interface NobAssessmentMapper {
	
	int deleteByPrimaryKey(String id);

	int insertSelective(NobAssessment record);

	NobAssessment selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobAssessment record);
	
	List<NobAssessment> find(@Param("map") Map<String, Object> map);

}