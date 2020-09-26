package com.gk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello")
	public String sayHello() {
		return "<h1 style='color:purple;'>Hello User! This application is created from Spring Initializr</h1>";
	}
}
