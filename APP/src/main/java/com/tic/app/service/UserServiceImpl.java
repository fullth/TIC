package com.tic.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tic.app.dao.UserDAO;
import com.tic.app.model.UserVO;

public class UserServiceImpl implements UserService{

	private final UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	//회원가입처리 
	@Override
	public void userResiter(UserVO userVO) throws Exception {
		userDAO.userResister(userVO);
	}

}
