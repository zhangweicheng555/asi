package com.boot.kaizen.business.nb.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.boot.kaizen.business.nb.model.NobCheck;

@Mapper
public interface NobCheckMapper {
	int deleteByPrimaryKey(String id);

	int insertSelective(NobCheck record);

	NobCheck selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobCheck record);

	List<NobCheck> find(@Param("map") Map<String, Object> map);
}