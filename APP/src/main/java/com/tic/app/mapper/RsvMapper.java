package com.tic.app.mapper;

import com.tic.app.model.RsvVO;

public interface RsvMapper {
	
	public int selectCountNumber(String to) throws Exception;
	
	public void insertNumber(RsvVO rsvVO) throws Exception;
}
