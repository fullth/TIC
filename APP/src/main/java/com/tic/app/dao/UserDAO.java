package com.tic.app.dao;

import com.tic.app.model.UserVO;

public interface UserDAO {
	
	// 회원가입 처리
	void userResister(UserVO userVO) throws Exception;
}
