package com.boot.kaizen.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.boot.kaizen.model.log.LoginService;

@Mapper
public interface SysLoginServiceDao {

	
	Long findProjByUserName(@Param("username") String username);
	
	void insert(LoginService loginService);

}
