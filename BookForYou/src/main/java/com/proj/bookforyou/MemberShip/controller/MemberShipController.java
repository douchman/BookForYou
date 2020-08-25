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

import com.proj.bookforyou.Library.DTO.Bookinfo;
import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.MemberShip.MemberAuthDTO;
import com.proj.bookforyou.MemberShip.UsrBookInfo;
import com.proj.bookforyou.MemberShip.usrBookHistory;
import com.proj.bookforyou.MemberShip.service.IMembershipService;
import com.proj.bookforyou.Recommend.service.IRecommendService;
import com.proj.bookforyou.TendsAnalysis.service.IHistoryService;
import com.proj.bookforyou.TendsAnalysis.service.ITendsAnalysisService;

import oracle.net.aso.l;
import oracle.net.aso.m;
import oracle.security.o3logon.a;



@SessionAttributes({"sessionMember", "sessionLogin","loginState","sessionHistory"})
@Controller
public class MemberShipController {

	private static final Logger logger = LoggerFactory.getLogger(MemberShipController.class);
	
	@Autowired
	private IMembershipService iMemserv;
	
	@Autowired
	private ITendsAnalysisService iTendserv;
	
	@Autowired
	private IRecommendService iRecommend;

	@Autowired
	private IHistoryService iHisServ;
	
	@ModelAttribute("sessionMember")
	public BfuMember getEmptyMember() {	
		return new BfuMember();
	}
	
	@ModelAttribute("sessionLogin")
	public BfuMember getLoginsession() {	
		return new BfuMember();
	}
	
	@ModelAttribute("loginState")
	public String getloginState() {	
		return "0";
	}
	@ModelAttribute("sessionHistory")
	public List<usrBookHistory> getHistory() {	
		return new ArrayList<usrBookHistory>();
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
		
		return "forward:/authProc";
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
		
		return "forward:/memberformNext";
		
	}
	

	
	@RequestMapping(value = "previousMemberShipPage")
	public String previousMemberShipPage(Model model, 
			@ModelAttribute("sessionMember")BfuMember member) {
		

		//model.addAttribute("member", member);
		model.addAttribute("sessionMember",member);
		
		return "forward:/memberformBack";
		
	}
	
	
	@RequestMapping(value = "membershipDone")
	public String membershipResult(Model model,
			@ModelAttribute("sessionMember")BfuMember member
			) {
		String authnum = iMemserv.memberProc(member);
		//String authnum = "";
		
		System.out.println("chk1");
		model.addAttribute("sessionMember",member);
		model.addAttribute("authNum",authnum);
		System.out.println("chk2");
		return "forward:/membershipResult";
	}
	
	
	@RequestMapping(value = "sendMail")
	public String sendMail(Model model,
			@ModelAttribute("sessionMember")BfuMember member,
			@RequestParam("usrAddress") String usrAddress,
			@RequestParam("authNum") String authNum,
			SessionStatus sessionStatus) {
		
		model.addAttribute("mailAddress",usrAddress);
		model.addAttribute("authNum",authNum);
		
		iRecommend.saveUsr(member.getUsrnickname());
		
		sessionStatus.setComplete();
		
		
		return "/MemberShip/sendMail";
	}
	
	@RequestMapping(value = "goMyPage")
	public String myPage(
			@ModelAttribute("sessionHistory") ArrayList<usrBookHistory> usrBookHistory,
			@ModelAttribute("sessionLogin")BfuMember member,
				Model model) {
		
		System.out.println("유저 북 리스트  isEmpty: " + usrBookHistory.isEmpty() + "크기 : " + usrBookHistory.size() );
	
		String maxContentSign = iHisServ.setHistoryLst(usrBookHistory);
		System.out.println("카운트 :" +maxContentSign) ;
		List<Bookinfo> bookLst  = iMemserv.getBookLst_basedHis(maxContentSign);		
		
		model.addAttribute("bookLst",bookLst);
		//model.addAttribute("",member)
		return "forward:/myPage";
		
	}
	
	
	@RequestMapping(value = "signout")
	public String signout(@ModelAttribute("sessionLogin")BfuMember member,
			@ModelAttribute("loginState") String loginState,
			SessionStatus sessionStatus,
				Model model) {
		
		if(!sessionStatus.isComplete()) {
			sessionStatus.setComplete();		
		}
		model.addAttribute("loginState","0");
		return "forward:/home";
		
	}
	
	
	
	@RequestMapping(value = "loginProc")
	public String loginProc(Model model,
							@ModelAttribute("sessionLogin") BfuMember member,
							@ModelAttribute("loginState") String loginState,
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
			
			System.out.println("리스트 크기 :"+ tmpLst.size() +"비어잇나 :" + tmpLst.isEmpty());
			member = iTendserv.getResult(tmpLst, member);
			
			// 그 리스트와 불러온 회원객체를 전달하여 필요한 값들을 회원객체에 추가하여 반환 받는다.
			
			model.addAttribute("sessionLogin",member);
			model.addAttribute("loginState","1");
			return "forward:/home";
		}
		
		else {
			model.addAttribute("member",member);
			return "forward:/signin";
			}	
	}
	
	@RequestMapping(value = "findID")
	public String findIDProc() {
		
		return "forward:/findIDForm";
	}
	
	@RequestMapping(value = "findPw")
	public String findPwProc() {
		
		return "forward:/findPwForm";
	}
	
	@RequestMapping(value = "selfConfirm")
	public String modifyAuth() {		
		return "forward:/modifyAuth";
	}
	
	@RequestMapping(value = "modify")
	public String modifyProc(@ModelAttribute("sessionLogin")BfuMember sessionmember,
				BfuMember member, Model model) {
		
		
		System.out.println(member.getPw());
		System.out.println(member.getUsrnickname());
		System.out.println(member.getAge());
		System.out.println(member.getFavorite());
		System.out.println(member.getFavorite2());
		System.out.println(member.getFavorite3());
		
		
		
		member.setUsrid(sessionmember.getUsrid());
		
		//입력된 정보로 멤버테이블 업데이트
		iMemserv.modifyProc(member);
		
		// 업데이트된 정보를 다시 받아와서 로그인 세션으로 객체저장
		sessionmember = iMemserv.getLoginSession(sessionmember.getUsrid());
		// 임시 Lst 에 해당 회원의정보로 책리스트를 받아오고
		List<UsrBookInfo> tmpLst = iMemserv.getUsrBookLst(sessionmember.getUsrid());
					
		// 반환 값이  null 아닐때만 성향분석서비스 호출 : 해당 유저의 책정보가 1개이상 있을 경우만
		if(tmpLst != null)
			sessionmember = iTendserv.getResult(tmpLst, sessionmember);
					
		// 그 리스트와 불러온 회원객체를 전달하여 필요한 값들을 회원객체에 추가하여 반환 받는다.			
		model.addAttribute("sessionLogin",sessionmember);
		
		return "home";
	}
	
	@RequestMapping(value = "chkPw")
	public String confirmPw(
			Model model,
			@ModelAttribute("sessionLogin")BfuMember member,
			@RequestParam("inputPw")String pw
			) {
		// 세션유지중인 멤버객체의 pw와 입력한 pw가 일치 할 경우
		if(member.getPw().contentEquals(pw)) {
			return "forward:/confirmPw";
		}
		// 아닐경우 다시 인증페이지로 이동
		else {
			model.addAttribute("authMsg","비밀번호가 일치하지 않습니다.");
			return "forward:/backtoAuth";
			}
		
	}
	
	
	@RequestMapping(value = "findIDProc")
	public String findID(@RequestParam("mode") String mode,MemberAuthDTO member,Model model) {
		//System.out.println(member.getUsrid());
		//System.out.println(mode);
		model.addAttribute("usrid",iMemserv.findIDProc(member));
		model.addAttribute("mode",mode);
		return "/MemberShip/findInfoResult";
	}
	
	
	@RequestMapping(value = "findPWProc")
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
