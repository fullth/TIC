package com.tic.app.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tic.app.model.RsvVO;
import com.tic.app.util.Constant;

@Repository
public class RsvMapperImpl implements RsvMapper{
	
	String namespace = Constant.NAMESPACE.toString() + ".RsvMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertNumber(RsvVO rsvVO) throws Exception {
		sqlSession.insert(namespace + ".insertNumber", rsvVO);
	}

	@Override
	public int selectCountNumber(RsvVO rsvVO) throws Exception {
		
		sqlSession.selectList(namespace + ".selectCountNumber", rsvVO);
		return 0 ;
	}

	@Override
	public HashMap<Integer, String> selectNumber(RsvVO rsvVO) throws Exception {
		
		sqlSession.selectList(namespace + ".selectNumber", rsvVO);
		return null;
	}

	
	
}
