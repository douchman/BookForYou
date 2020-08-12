package com.proj.bookforyou.MemberShip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberShipController {

	
	
	@RequestMapping(value = "memberProc")
	public String memberProc() {
		return "/MemberShip/membershipForm";
		
	}
	
		
	@RequestMapping(value = "previousMemberShipPage")
	public String previousMemberShipPage() {
		return "/MemberShip/membershipForm";
		
	}
	
	@RequestMapping(value = "nextMemberShipPage")
	public String nextMemberShipPage() {
		return "/MemberShip/membershipForm2";
		
	}
	
	@RequestMapping(value = "myPage")
	public String myPage() {
		return "/myPage/myPageForm";
		
	}
	
	
}
