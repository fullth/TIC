package com.tic.app.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tic.app.model.UserVO;
import com.tic.app.service.UserService;

@Controller
public class UserRegController {
		
//	private final UserService userService;
//	
//	@Autowired
//	public UserRegController(UserService userService) {
//		this.userService = userService;
//	}
//			
//	@GetMapping(value="/join")
//	public String registerGET() throws Exception {
//		return "/user/join";
//	}
//	
//	@PostMapping(value="/register")
//	public String registerPOST(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception {
//		
//		String hashedPw = BCrypt.hashpw(userVO.getUSER_PW(), BCrypt.gensalt());
//		userVO.setUSER_PW(hashedPw);
//		userService.userResiter(userVO);
//		redirectAttributes.addFlashAttribute("msg", "RESISTERED");
//		
//		return "redirect:/login";
//	}
}
