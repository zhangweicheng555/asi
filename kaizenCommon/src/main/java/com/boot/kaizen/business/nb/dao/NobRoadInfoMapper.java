package com.boot.kaizen.business.nb.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.boot.kaizen.business.nb.model.NobRoadInfo;

@Mapper
public interface NobRoadInfoMapper {
	int deleteByPrimaryKey(String id);

	int insertSelective(NobRoadInfo record);

	NobRoadInfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobRoadInfo record);

	List<NobRoadInfo> find(@Param("map") Map<String, Object> map);
}