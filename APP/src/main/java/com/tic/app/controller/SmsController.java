package com.tic.app.controller;

import java.io.IOException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tic.app.model.RsvVO;
import com.tic.app.model.UserVO;
import com.tic.app.service.SmsSendServiceImpl;

@Controller
public class SmsController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	SmsSendServiceImpl smsSendServiceImpl;
	
	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("@RequestMapping::: /sms");
		return "sms";
	}
	
	@PostMapping(value="/sendSms")
	public String sendSms(@RequestParam(value="to")String to
						  //@RequestParam(value="from")String from,
						  //@RequestParam(value="text")String text
						  ) throws IOException {
		
		//smsSendServiceImpl.sendSMS(to, from, text);
		smsSendServiceImpl.sendSMS(to);
		
		return "regNumber";
	}
	
	@PostMapping(value="/regNumber")
	public String regNumber(RsvVO rsvVO, RedirectAttributes redirectAttributes) throws Exception {
		
		logger.info("@RequestMapping::: /regNumber");
		String hashedPw = BCrypt.hashpw(rsvVO.getPhoneNumber(), BCrypt.gensalt());
		rsvVO.setPhoneNumber(hashedPw);
		smsSendServiceImpl.insertNumber(rsvVO);
		
		return "redirect:/sms";
	}
}
