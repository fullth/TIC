package com.tic.app.mapper;

import java.util.ArrayList;

import com.tic.app.model.RsvVO;

public interface RsvMapper {
	
	public int selectCountNumber(RsvVO rsvVO) throws Exception;
		
	public void insertNumber(RsvVO rsvVO) throws Exception;
	
	public ArrayList<RsvVO> selectNumber(RsvVO rsvVo) throws Exception;
	
	public ArrayList<RsvVO> selectAllRegedNumber(RsvVO rsvVO) throws Exception;
}
