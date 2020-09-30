package com.gk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public String showLoginForm() {
		return "loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLogin(@RequestParam String username, @RequestParam String password, ModelMap map) {
		map.addAttribute("user", username);//adding key To bind the dyanamic value to JSP's.
		String status = "";
		if (username.equals("Pranay Singh") && password.equals("abc123")) {
			status = "success";
		} else {
			status = "failure";
		}
		return status;
	}

}
