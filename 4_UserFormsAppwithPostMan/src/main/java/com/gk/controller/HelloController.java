package com.gk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "HelloForm";
	}
	
	@RequestMapping(value = "/wish",method = RequestMethod.POST)
	public String wish(@RequestParam String username, ModelMap map) {
		map.addAttribute("uname",username);
		return "WishPage";
	}
}
