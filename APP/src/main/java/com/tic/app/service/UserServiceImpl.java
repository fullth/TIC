package com.tic.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tic.app.dao.UserDAO;
import com.tic.app.model.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void userResiter(UserVO userVO) throws Exception {
		userDAO.userResister(userVO);
	}

}
