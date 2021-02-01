package com.tic.app.remind;

//@Service
public class HelloServiceProxy extends HelloServiceImpl{
	
	@Override
	public String sayHello(String name) {
		HelloLog.log();
		return super.sayHello(name);
	}
}
