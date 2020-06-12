package com.hello.filters;

public class RequestIdThreadLocal {
	
	
	public static ThreadLocal<String> requestId = new ThreadLocal<String>();
	
	public static ThreadLocal<String> getThreadLocal() {
		return requestId;
	}

}
