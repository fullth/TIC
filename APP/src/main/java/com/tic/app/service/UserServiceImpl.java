package com.tic.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tic.app.mapper.UserMapper;
import com.tic.app.model.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void insertUser(UserVO userVO) throws Exception {
		userMapper.insertUser(userVO);
	}
}
