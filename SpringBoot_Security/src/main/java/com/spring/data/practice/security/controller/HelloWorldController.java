package com.spring.data.practice.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class HelloWorldController {

	@RequestMapping("/sayHello")
	public String sayHello() {
		return "Hello Everyone..!";
	}

}
