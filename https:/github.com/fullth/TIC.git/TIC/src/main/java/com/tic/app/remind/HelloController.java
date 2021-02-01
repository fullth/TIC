package com.tic.app.remind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
	@Autowired
	HelloService helloService;
	
	// DI with constructor
//	public HelloController(HelloService helloService) {
//		this.helloService = helloService;
//	}
	
	// Di with set method
//	public void setHelloService(HelloService helloService) {
//		this.helloService = helloService;
//	}
	
	public void hello(String name) {
		System.out.println("HelloController : " + helloService.sayHello(name));
	}
}
