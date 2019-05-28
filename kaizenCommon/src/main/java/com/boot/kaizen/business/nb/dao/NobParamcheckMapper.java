package com.boot.kaizen.business.nb.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.boot.kaizen.business.nb.model.NobParamcheck;

@Mapper
public interface NobParamcheckMapper {
	int deleteByPrimaryKey(String id);

	int insertSelective(NobParamcheck record);

	NobParamcheck selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobParamcheck record);

	List<NobParamcheck> find(@Param("map") Map<String, Object> map);
}