package com.proj.bookforyou.MemberShip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.bookforyou.MemberShip.BfuMember;

import oracle.net.aso.m;



@Controller
public class MemberShipController {

	private static final Logger logger = LoggerFactory.getLogger(MemberShipController.class);
	
	@RequestMapping(value = "memberProc")
	public String memberProc() {
		return "/MemberShip/membershipForm";
		
	}
	
		
	@RequestMapping(value = "previousMemberShipPage")
	public String previousMemberShipPage(Model model, BfuMember member) {
		

		model.addAttribute("member", member);
		
		return "/MemberShip/membershipForm";
		
	}
	
	@RequestMapping(value = "nextMemberShipPage")
	public String nextMemberShipPage(Model model,
			BfuMember member
			) {

		model.addAttribute("member",member);
		
		return "/MemberShip/membershipForm2";
		
	}
	
	
	@RequestMapping(value = "membershipResult")
	public String membershipResult(Model model,
			BfuMember member
			) {

		model.addAttribute("member",member);
		
		return "/MemberShip/membershipResult";
		
	}
	
	
	
	@RequestMapping(value = "myPage")
	public String myPage() {
		return "/myPage/myPageForm";
		
	}
	
	
}
