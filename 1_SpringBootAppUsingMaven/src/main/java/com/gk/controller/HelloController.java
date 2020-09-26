package com.gk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController = @Controller + @ResponseBody
 */
@RestController
public class HelloController {

	@RequestMapping(value = "/hello")
	public String sayHello() {
		return "Hello User! Welcome to Spring Boot Learning...";
	}
}
