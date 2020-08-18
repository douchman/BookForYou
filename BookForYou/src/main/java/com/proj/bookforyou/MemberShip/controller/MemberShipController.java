package com.proj.bookforyou.MemberShip.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.MemberShip.MemberAuthDTO;
import com.proj.bookforyou.MemberShip.service.IMembershipService;

import oracle.net.aso.l;
import oracle.net.aso.m;
import oracle.security.o3logon.a;



@SessionAttributes({"sessionMember", "sessionLogin"})
@Controller
public class MemberShipController {

	private static final Logger logger = LoggerFactory.getLogger(MemberShipController.class);
	
	@Autowired
	private IMembershipService iMemserv;
	
	
	
	
	@ModelAttribute("sessionMember")
	public BfuMember getEmptyMember() {	
		return new BfuMember();
	}
	
	@ModelAttribute("sessionLogin")
	public BfuMember getLoginsession() {	
		return new BfuMember();
	}
	
	
	
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
			@RequestParam("authNum") String authNum,
			@RequestParam("usrid") String usrid
			) {
		
		MemberAuthDTO authDTO = new MemberAuthDTO();
		
		authDTO.setUsrid(usrid);
		authDTO.setAuthNum(authNum);
		
		System.out.println("authDone Call");
		model.addAttribute("authNum" ,iMemserv.authProc(authDTO));
		
		return "/MemberShip/authDone";
	}
	
	@RequestMapping(value = "previousMemberShipPage")
	public String previousMemberShipPage(Model model, @ModelAttribute("sessionMember")BfuMember member) {
		

		//model.addAttribute("member", member);
		model.addAttribute("member",member);
		
		return "/MemberShip/membershipForm";
		
	}
	
	@RequestMapping(value = "nextMemberShipPage")
	public String nextMemberShipPage(Model model,
			@ModelAttribute("sessionMember") BfuMember member
			) {

		logger.info(member.getUsrid());
		logger.info(member.getUsrnickname());
		logger.info(member.getPw());
		logger.info(member.getGender());
		logger.info(String.valueOf(member.getAge()));
		
		//model.addAttribute("member",member);
		model.addAttribute("sessionMember",member);
		
		return "/MemberShip/membershipForm2";
		
	}
	
	
	@RequestMapping(value = "membershipResult")
	public String membershipResult(Model model,
			@ModelAttribute("member")BfuMember member
			) {
		String authnum = iMemserv.memberProc(member);
		//String authnum = "";
		
		model.addAttribute("sessionMember",member);
		model.addAttribute("authNum",authnum);
		
		return "/MemberShip/membershipResult";
	}
	
	
	@RequestMapping(value = "sendMail")
	public String sendMail(Model model,
			@ModelAttribute("sessionMember")BfuMember member,
			@RequestParam("usrAddress") String usrAddress,
			@RequestParam("authNum") String authNum,
			SessionStatus sessionStatus) {
		
		model.addAttribute("mailAddress",usrAddress);
		model.addAttribute("authNum",authNum);
		
		sessionStatus.setComplete();
		
		
		return "/MemberShip/sendMail";
	}
	
	@RequestMapping(value = "myPage")
	public String myPage() {
		return "/myPage/myPageForm";
		
	}
	
	@RequestMapping(value = "loginProc")
	public String loginProc(Model model,
							BfuMember member,
							@RequestParam("usrid")String usrid,
							@RequestParam("pw")String pw,
							
							@ModelAttribute("sessionLogin") BfuMember loginSession) {
	
		member.setLoginResult(iMemserv.loginProc(member));
		
		// 로그인 성공처리
		if("3".contentEquals(member.getLoginResult())) {
				
			model.addAttribute("sessionLogin",iMemserv.getLoginSession(usrid));
			
			return "home";
		}
		
		else {
			model.addAttribute("member",member);
			return "/Login/loginForm";
			}	
	}
	
	@RequestMapping(value = "findIDProc")
	public String findIDProc() {
		
		return "/MemberShip/findIDForm";
	}
	
	@RequestMapping(value = "findPwProc")
	public String findPwProc() {
		
		return "/MemberShip/findPwForm";
	}
	
	
	@RequestMapping(value = "findID")
	public String findID(@RequestParam("mode") String mode,MemberAuthDTO member,Model model) {
		//System.out.println(member.getUsrid());
		//System.out.println(mode);
		model.addAttribute("usrid",iMemserv.findIDProc(member));
		model.addAttribute("mode",mode);
		return "/MemberShip/findInfoResult";
	}
	
	
	@RequestMapping(value = "findPW")
	public String findPW(@RequestParam("mode") String mode,MemberAuthDTO member,Model model) {
		//model.addAttribute("usrid",iMemserv.findIDProc(member));
		model.addAttribute("mode",mode);
		return "/MemberShip/findInfoResult";
	}
	
}
