package com.boot.kaizen.service;

import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.entity.Token;


public interface TokenService {

	Token saveToken(LoginUser loginUser);

	void refresh(LoginUser loginUser);

	LoginUser getLoginUser(String token);

	boolean deleteToken(String token);

}
