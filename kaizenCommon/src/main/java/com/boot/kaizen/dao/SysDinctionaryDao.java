package com.boot.kaizen.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.kaizen.model.SysDic;

@Mapper
public interface SysDinctionaryDao {

	@Select("select  p.* from t_dict p where p.type= #{type} order by p.sort asc")
	List<SysDic> findByType(String type);

}
