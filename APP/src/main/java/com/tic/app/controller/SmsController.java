package com.tic.app.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tic.app.mapper.RsvMapper;
import com.tic.app.model.RsvVO;
import com.tic.app.service.SmsSendServiceImpl;

@Controller
public class SmsController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	SmsSendServiceImpl smsSendServiceImpl;
	
	@Autowired
	SmsController smsController;
	
	@Autowired
	RsvMapper rsvMapper;
	
	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("SmsController.sms");
		return "sms";
	}
	
	@PostMapping(value="/sendSms")
	public String sendSms(@RequestParam(value="to")String to,
						  RsvVO rsvVO
						  ) throws Exception {
		logger.info("SmsController.sendSms");
		
		rsvVO.setPhoneNumber(to);
		
		ArrayList<RsvVO> result = rsvMapper.selectNumber(rsvVO);
		if(result.isEmpty()) {
			smsController.regNumber(rsvVO);
			smsSendServiceImpl.sendSMS(to, rsvVO);
			logger.info("Unregistered number.");
		} else {
			//smsSendServiceImpl.sendSMS(to, rsvVO);
			Object object = rsvMapper.selectAllRegedNumber(rsvVO);
			logger.info("Get query result ::: ", object);
			logger.info("Registered number.");
		}
		
		return "redirect:/sms";
	}
	
	/** @unused */
	public boolean checkNumber(RsvVO rsvVO) {
		logger.info("SmsController.checkNumber");
		boolean prcsCmplt = false;
		
		int chkExistNum;
		try {
			chkExistNum = smsSendServiceImpl.selectCountNumber(rsvVO);
			if(chkExistNum > 0) {
				//Exception e = new Exception("EXIST NUMBER");
				//throw e;
				// TODO Start Here.
			} else {
				smsController.regNumber(rsvVO);
				prcsCmplt = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prcsCmplt;
	}
	
	public void regNumber(RsvVO rsvVO) throws Exception {
		
		logger.info("SmsController.regNumber");
		
		// BCrypt only support one way encryption.
		// String hashedNumber = BCrypt.hashpw(rsvVO.getPhoneNumber(), BCrypt.gensalt());
		String rowNumber = rsvVO.getPhoneNumber();
		
		// BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder(10);
		// bcryptPasswordEncoder.matches(rowPw, hashedNumber);
		
		// System.out.println(bcryptPasswordEncoder.matches(rowPw, hashedNumber));
		
		// rsvVO.setPhoneNumber(hashedNumber);
		rsvVO.setPhoneNumber(rowNumber);
		smsSendServiceImpl.insertNumber(rsvVO);
	}
}
