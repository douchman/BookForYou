package com.proj.bookforyou.MemberShip.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

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
import com.proj.bookforyou.MemberShip.UsrBookInfo;
import com.proj.bookforyou.MemberShip.service.IMembershipService;
import com.proj.bookforyou.Recommend.service.IRecommendService;
import com.proj.bookforyou.TendsAnalysis.service.ITendsAnalysisService;

import oracle.net.aso.l;
import oracle.net.aso.m;
import oracle.security.o3logon.a;



@SessionAttributes({"sessionMember", "sessionLogin"})
@Controller
public class MemberShipController {

	private static final Logger logger = LoggerFactory.getLogger(MemberShipController.class);
	
	@Autowired
	private IMembershipService iMemserv;
	
	@Autowired
	private ITendsAnalysisService iTendserv;
	
	@Autowired
	private IRecommendService iRecommend;

	
	@ModelAttribute("sessionMember")
	public BfuMember getEmptyMember() {	
		return new BfuMember();
	}
	
	@ModelAttribute("sessionLogin")
	public BfuMember getLoginsession() {	
		return new BfuMember();
	}
	
	
	
	@RequestMapping(value = "memberProc")
	public String memberProc(@ModelAttribute("sessionMember") BfuMember member) {
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
		
		model.addAttribute("authNum" ,iMemserv.authProc(authDTO));
		
		return "/MemberShip/authDone";
	}
	
	@RequestMapping(value = "previousMemberShipPage")
	public String previousMemberShipPage(Model model, 
			@ModelAttribute("sessionMember")BfuMember member) {
		

		//model.addAttribute("member", member);
		model.addAttribute("sessionMember",member);
		
		return "/MemberShip/membershipForm";
		
	}
	
	@RequestMapping(value = "nextMemberShipPage")
	public String nextMemberShipPage(Model model,
			@ModelAttribute("sessionMember")BfuMember member
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
			@ModelAttribute("sessionMember")BfuMember member
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
		
		iRecommend.saveUsr(member.getUsrid());
		
		sessionStatus.setComplete();
		
		
		return "/MemberShip/sendMail";
	}
	
	@RequestMapping(value = "myPage")
	public String myPage(@ModelAttribute("sessionLogin")BfuMember member,
				Model model) {
		
		//model.addAttribute("",member)
		return "/myPage/myPageForm";
		
	}
	
	@RequestMapping(value = "loginProc")
	public String loginProc(Model model,
							@ModelAttribute("sessionLogin") BfuMember member,
							@RequestParam("usrid")String usrid,
							@RequestParam("pw")String pw) {
	
		member.setLoginResult(iMemserv.loginProc(member));
		
		// 로그인 성공처리
		if("3".contentEquals(member.getLoginResult())) {
			// 해당 아이디로 로그인결과가 성공이면
			// 해당하는 아이디로 세션에 등록할 객체 정보를 끌어와 저장한다.
			member = iMemserv.getLoginSession(usrid);
			
			// 임시 Lst 에 해당 회원의정보로 책리스트를 받아오고
			List<UsrBookInfo> tmpLst = iMemserv.getUsrBookLst(member.getUsrid());
			
			// 반환 값이  null 아닐때만 성향분석서비스 호출 : 해당 유저의 책정보가 1개이상 있을 경우만
			if(tmpLst != null)
				member = iTendserv.getResult(tmpLst, member);
			
			// 그 리스트와 불러온 회원객체를 전달하여 필요한 값들을 회원객체에 추가하여 반환 받는다.
			
			model.addAttribute("sessionLogin",member);
			
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
	
	@RequestMapping(value = "modifyAuth")
	public String modifyAuth() {		
		return "/myPage/modifyAuth";
	}
	
	@RequestMapping(value = "confirmPw")
	public String confirmPw(
			@ModelAttribute("sessionLogin")BfuMember member,
			@RequestParam("inputPw")String pw
			) {
		// 세션유지중인 멤버객체의 pw와 입력한 pw가 일치 할 경우
		if(member.getPw().contentEquals(pw)) {
			return "/myPage/modifyForm";
		}
		// 아닐경우 다시 인증페이지로 이동
		else {
			return "/myPage/modifyAuth";
			}
		
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
	
	@RequestMapping(value = "getUsrBoofInfo")
	public String getUsrBoofInfo(
			@RequestParam("usrid") String usrid,
			@ModelAttribute("sessionLogin")BfuMember member,
			Model model) {
		List<UsrBookInfo> tmpLst = iMemserv.getUsrBookLst(usrid);
		
		iTendserv.setUsrBookLst(tmpLst, member);
		model.addAttribute("bookLst",tmpLst);
		return "/MemberShip/bookTest";
	}
	
}
