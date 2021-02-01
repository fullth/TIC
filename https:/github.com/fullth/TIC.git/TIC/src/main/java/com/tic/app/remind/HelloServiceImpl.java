package com.tic.app.remind;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello(String name) {
		System.out.println("HelloService.sayHello()");
		return "Hello " + name;
	}

}
