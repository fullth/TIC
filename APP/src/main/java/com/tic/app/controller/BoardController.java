package com.tic.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	/**
	 * 
	 * @Description 서비스 에러등록 게시판  
	 * 
	 **/
	@GetMapping("/errBoard")
	public void errBoard() {
		logger.info("@GetMapping[ /errBoard ]");
	}
}

