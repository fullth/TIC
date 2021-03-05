package com.tic.app.controller;

import java.util.Locale;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tic.app.model.RsvVO;
import com.tic.app.service.SmsSendServiceImpl;

@Controller
public class SmsController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	SmsSendServiceImpl smsSendServiceImpl;
	
	@Autowired
	SmsController smsController;
	
	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("SmsController.sms");
		return "sms";
	}
	
	@PostMapping(value="/sendSms")
	public String sendSms(@RequestParam(value="to")String to,
						  RsvVO rsvVO
						  //@RequestParam(value="from")String from,
						  //@RequestParam(value="text")String text
						  ) throws Exception {
		logger.info("SmsController.sendSms");
		
		rsvVO.setPhoneNumber(to);
		
		if (smsController.checkNumber(rsvVO) == true) {			
			smsSendServiceImpl.sendSMS(to);
			return "redirect:/sms";
		}
		
		return "NotFound404";
	}
	
	public boolean checkNumber(RsvVO rsvVO) {
		logger.info("SmsController.checkNumber");
		boolean prcsCmplt = false;
		
		rsvVO.getPhoneNumber();
		
		int chkExistNum;
		try {
			chkExistNum = smsSendServiceImpl.selectCountNumber(rsvVO);
			System.out.println();
			System.out.println(chkExistNum);
			System.out.println();
			if(chkExistNum > 0) {
				Exception e = new Exception("EXIST NUMBER");
				throw e;
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
		String hashedPw = BCrypt.hashpw(rsvVO.getPhoneNumber(), BCrypt.gensalt());
		rsvVO.setPhoneNumber(hashedPw);
		smsSendServiceImpl.insertNumber(rsvVO);
	}
}
