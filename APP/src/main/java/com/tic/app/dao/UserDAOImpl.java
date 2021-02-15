package com.tic.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.tic.app.model.UserVO;

public class UserDAOImpl implements UserDAO{

	private static final String NAMESPACE = "com.tic.app.adm.AdmUserMapper";
	
	private final SqlSession sqlSession;
	
	@Autowired
	public UserDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 회원가입처리 
	@Override
	public void userResister(UserVO userVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".insertUserRegInfo", userVO);
	}

}
