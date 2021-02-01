package com.tic.app.remind;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main(String args[]) {
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("application-config.xml");
		
		HelloController helloController = context.getBean(HelloController.class);
		helloController.hello("TEST");
	}
}
	