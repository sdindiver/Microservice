package com.hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@org.springframework.web.bind.annotation.RestController
public class RestController 
{
  	
	@RequestMapping(path="/hello", method=RequestMethod.GET)
	public ResponseEntity<Object> hello(){
        return ResponseEntity.ok("Hello");

	}
	

 
   
}
