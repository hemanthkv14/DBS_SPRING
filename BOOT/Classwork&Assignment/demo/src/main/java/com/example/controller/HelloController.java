package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/test1")
	public String Hello()
	{
		System.out.println("In the Hello()");
		return "Hey!! Request Mapping successful";
	}

}