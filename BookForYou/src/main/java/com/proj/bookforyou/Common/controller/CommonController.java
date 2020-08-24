package com.proj.bookforyou.Common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proj.bookforyou.MemberShip.BfuMember;

@Controller
public class CommonController {

	
	@RequestMapping("login")
	public String login(BfuMember member) {
		
		
		return "/Login/loginForm";
		
	}
	

}
