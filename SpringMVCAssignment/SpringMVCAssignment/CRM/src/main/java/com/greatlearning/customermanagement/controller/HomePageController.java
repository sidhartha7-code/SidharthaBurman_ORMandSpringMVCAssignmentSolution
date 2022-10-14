package com.greatlearning.customermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

	@RequestMapping("/")
	public String showPage() {
		//return "main-menu";
		 return "redirect:/customer/list";
	}
}
