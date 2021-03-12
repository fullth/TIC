package com.tic.app.mapper;

import java.util.HashMap;

import com.tic.app.model.RsvVO;

public interface RsvMapper {
	
	public int selectCountNumber(RsvVO rsvVO) throws Exception;
		
	public void insertNumber(RsvVO rsvVO) throws Exception;
	
	public HashMap<Integer, String> selectNumber(RsvVO rsvVo) throws Exception;
}
