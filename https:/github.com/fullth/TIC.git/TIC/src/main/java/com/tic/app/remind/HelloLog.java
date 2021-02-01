package com.tic.app.remind;

import org.springframework.stereotype.Component;

@Component
public class HelloLog {
	public static void log() {
		System.out.println(new java.util.Date());
	}
}
