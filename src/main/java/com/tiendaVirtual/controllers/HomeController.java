package com.nttdata.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "/home/home.jsp";
	}
	
	
	
	// <jsp:include page<jsp:include page='template/header.jsp'/>'template/header.jsp'/>
}
