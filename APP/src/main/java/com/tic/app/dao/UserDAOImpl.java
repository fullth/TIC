package com.tic.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tic.app.model.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{

	private static final String NAMESPACE = "com.tic.app.service.AdmUserRegService";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void userResister(UserVO userVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".insertUserRegInfo", userVO);
	}

}
