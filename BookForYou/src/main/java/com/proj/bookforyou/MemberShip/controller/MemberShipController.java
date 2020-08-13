package com.proj.bookforyou.MemberShip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.MemberShip.service.IMembershipService;

import oracle.security.o3logon.a;




@Controller
public class MemberShipController {

	private static final Logger logger = LoggerFactory.getLogger(MemberShipController.class);
	
	@Autowired
	private IMembershipService iMemserv;
	
	@RequestMapping(value = "memberProc")
	public String memberProc() {
		return "/MemberShip/membershipForm";
		
	}
	
	@RequestMapping(value = "isExistId")	
	@ResponseBody
	public String isExistId(BfuMember member) {
				
		
		member.setIdQueryRes(iMemserv.isExistId(member));
		
		return member.getIdQueryRes();
		
	}
	
	
	@RequestMapping(value = "isExistNickName")	
	@ResponseBody
	public String isExistNickName(BfuMember member) {
				
		
		member.setNicknameQueryRes(iMemserv.isExistNickName(member));
		
		return member.getNicknameQueryRes();
		
	}
	
	
	@RequestMapping(value = "authDone")
	public String authDone(Model model,
			@RequestParam("authNum") String authNum
			) {
		
		model.addAttribute("authNum" ,authNum);
		return "/MemberShip/authDone";
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

		logger.info(member.getUsrid());
		logger.info(member.getUsrnickname());
		logger.info(member.getPw());
		logger.info(member.getGender());
		logger.info(String.valueOf(member.getAge()));
		
		model.addAttribute("member",member);
		
		return "/MemberShip/membershipForm2";
		
	}
	
	
	@RequestMapping(value = "membershipResult")
	public String membershipResult(Model model,
			BfuMember member
			) {
		iMemserv.memberProc(member);
		
		model.addAttribute("member",member);
		
		return "/MemberShip/membershipResult";
	}
	
	
	@RequestMapping(value = "sendMail")
	public String sendMail(Model model,
			@RequestParam("usrAddress") String usrAddress) {
		
		model.addAttribute("mailAddress",usrAddress);
		
		return "/MemberShip/sendMail";
	}
	
	@RequestMapping(value = "myPage")
	public String myPage() {
		return "/myPage/myPageForm";
		
	}
	
	
}
