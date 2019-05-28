package com.boot.kaizen.business.nb.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.boot.kaizen.business.nb.model.NobGcb;

@Mapper
public interface NobGcbMapper {

	int deleteByPrimaryKey(String id);

	int insertSelective(NobGcb record);

	NobGcb selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(NobGcb record);

	List<NobGcb> find(@Param("map") Map<String, Object> map);
}