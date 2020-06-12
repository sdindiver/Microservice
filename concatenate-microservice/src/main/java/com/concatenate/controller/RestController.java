package com.concatenate.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.concatenate.modal.Data;


@org.springframework.web.bind.annotation.RestController
public class RestController 
{
  	
	
	@RequestMapping(value = "/concatenate", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
	public ResponseEntity<Object> getConcatenatedString(@RequestBody Data data){
        return ResponseEntity.ok(data.getName() + " " + data.getSurName());
	}
 
   
}
