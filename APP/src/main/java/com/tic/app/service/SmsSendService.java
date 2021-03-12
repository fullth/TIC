package com.tic.app.service;

import java.util.HashMap;

import com.tic.app.model.RsvVO;

public interface SmsSendService {
	public void insertNumber(RsvVO rsvVO) throws Exception;
	
	public int selectCountNumber(RsvVO rsvVO) throws Exception;
	
	public HashMap<Integer, String> selectNumber(RsvVO rsvVo) throws Exception;
}
