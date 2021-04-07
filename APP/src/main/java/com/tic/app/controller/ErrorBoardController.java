package com.tic.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tic.app.mapper.ErrBoardMapper;
import com.tic.app.model.ErrBoard;

@Controller
public class ErrorBoardController {
	
	@Autowired
	ErrBoardMapper errboardMapper;
	
	@GetMapping("/test")
	public String test(Model model) {
		
		List<ErrBoard> board = new ArrayList<>();
		board = errboardMapper.selectErrList();
		
		System.out.println(board);
		
		model.addAttribute("boards", board);
		
		return "errBoard";
	}
}
