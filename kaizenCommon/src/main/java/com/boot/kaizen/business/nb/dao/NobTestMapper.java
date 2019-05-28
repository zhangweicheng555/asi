package com.boot.kaizen.business.nb.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.boot.kaizen.business.nb.model.NobTest;


@Mapper
public interface NobTestMapper {
	
	int deleteByPrimaryKey(String id);

	int insertSelective(NobTest record);

	NobTest selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobTest record);
	
	List<NobTest> find(@Param("map") Map<String, Object> map);

}