package com.tic.app.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tic.app.model.UserVO;
import com.tic.app.util.Constant;

@Repository
public class UserMapperImpl implements UserMapper{
	
	String namespace = Constant.NAMESPACE.toString() + ".UserMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertUser(UserVO userVO) throws Exception {
		sqlSession.insert(namespace + ".insertUser", userVO);
	}

}
