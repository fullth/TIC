package com.tic.app.controller;

import java.io.IOException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tic.app.service.SmsSendService;

@Controller
public class SmsController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	SmsSendService smsSendService;
	
	@RequestMapping(value = "/sms", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("@RequestMapping::: /sms");
		return "sms";
	}
	
	@RequestMapping(value="/sendSms")
	public String sendSms(@RequestParam(value="to")String to,
						  @RequestParam(value="from")String from,
						  @RequestParam(value="text")String text) throws IOException {
		
		smsSendService.sendSMS(to, from, text);
		
		return "redirect:/sms";
	}
}
