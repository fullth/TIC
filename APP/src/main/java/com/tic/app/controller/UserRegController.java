package com.tic.app.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tic.app.model.UserVO;
import com.tic.app.service.UserService;

@Controller
public class UserRegController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/join")
	public String registerPOST(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception {
		
		String hashedPw = BCrypt.hashpw(userVO.getUSER_PW(), BCrypt.gensalt());
		userVO.setUSER_PW(hashedPw);
		userService.insertUser(userVO);
		redirectAttributes.addFlashAttribute("msg", "RESISTERED");
		
		return "redirect:/login";
	}
}
