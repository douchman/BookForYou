package com.proj.bookforyou.Common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proj.bookforyou.MemberShip.BfuMember;

@Controller
public class CommonController {
	
	private Map<String, String> pageMap;
	
	public CommonController() {
		pageMap = new HashMap<String, String>();
		pageMap.put("home", "home");
		pageMap.put("signin", "Login/loginForm");
		pageMap.put("signup", "MemberShip/membershipForm");
		pageMap.put("memberformBack", "MemberShip/membershipForm");
		pageMap.put("memberformNext", "MemberShip/membershipForm2");
		pageMap.put("membershipResult", "MemberShip/membershipResult");
		pageMap.put("myPage", "myPage/myPageForm");
		pageMap.put("findIDForm", "MemberShip/findIDForm");
		pageMap.put("findPwForm", "MemberShip/findPwForm");
		pageMap.put("modifyAuth", "myPage/modifyAuth");
		pageMap.put("confirmPw", "myPage/modifyForm");
		pageMap.put("backtoAuth", "myPage/modifyAuth");
		pageMap.put("findIDProc", "myPage/MemberShip/findInfoResult");
		pageMap.put("findPWProc", "myPage/MemberShip/findInfoResult");
		pageMap.put("authProc", "MemberShip/authDone");
		//pageMap.put("home", "home");
		//pageMap.put("home", "home");
		//pageMap.put("home", "home");
		
		
	}
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		System.out.println("common call 1");
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/{formPath}")
	public String path(Model model, @PathVariable String formPath) {
		model.addAttribute("formPath", "form/" + formPath);
		System.out.println("common call 2");
		return "index";
	}
	
	@RequestMapping(value = "/form/{formPath}")
	public String formpath(@PathVariable String formPath) {
		System.out.println("common call 3");
		return pageMap.get(formPath);
	}


}
