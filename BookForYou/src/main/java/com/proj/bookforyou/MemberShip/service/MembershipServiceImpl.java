package com.proj.bookforyou.MemberShip.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.bookforyou.Library.DTO.Bookinfo;
import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.MemberShip.ImemberDAO;
import com.proj.bookforyou.MemberShip.MemberAuthDTO;
import com.proj.bookforyou.MemberShip.UsrBookInfo;

import Mail.AuthnumGenerator;
import Mail.ParkMail;
import oracle.net.aso.m;

@Service
public class MembershipServiceImpl implements IMembershipService {


		
	@Autowired
	private ImemberDAO memdao;

	@Override
	public String isExistId(BfuMember member) {
		// id가 이미 있을경우에는 1 없을경우에는 0 를 반환한다.
		

		return memdao.isExistId(member);
	}

	@Override
	public String isExistNickName(BfuMember member) {

		return memdao.isExistNickName(member);
	}

	@Override
	public String memberProc(BfuMember member) {
		
		AuthnumGenerator auth = new AuthnumGenerator();
		
		// 여기서 Authnum 을 생성해서 테이블에 올려놓고
		// 메일 전송 페이지로 함께 보낸다.
		
		String authNum = auth.getAuthNum();
		//System.out.println("생성된 인증번호 : " + authNum);
		
		
		System.out.println("id"+member.getUsrid());
		System.out.println("nick"+member.getUsrnickname());
		System.out.println("pw"+member.getPw());
		System.out.println("gen"+member.getGender());
		System.out.println("age"+member.getAge());
		System.out.println("f1"+member.getFavorite());
		System.out.println("f2"+member.getFavorite2());
		System.out.println("f3"+member.getFavorite3());
		
		member.setUsrauthnum(authNum);
		
		
		member.setAge(Integer.valueOf(member.getAge()));
		
		memdao.insertMember(member);
		
		return authNum;
	}
	
	@Override
	public boolean authProc(MemberAuthDTO authDTO) {
		
		String usrAuthNum = memdao.selectUsrAuthNum(authDTO);
		System.out.println("usr authNum = " + usrAuthNum);
		
		if(authDTO.getAuthNum().contentEquals(usrAuthNum)) {
			memdao.updateMemberState(authDTO);
			return true;
			}
		else
			return false;
	}
	
	
	@Override
	public String loginProc(BfuMember member) {
		System.out.println(member.getUsrid());
		System.out.println(member.getPw());
		
		HashMap<String , String > usrInfo = memdao.selectUsrinfo(member);
		
		String result = "";
		System.out.println("pw : "+usrInfo.get("pw"));
		System.out.println("s state : "+usrInfo.get("serviceState"));
		
		// 0 반환시 아이디가 없는것
		// 아이디가 존재하지 않을경우 0 반환
		if("0".contentEquals(usrInfo.get("pw")))
			result = "0";
		// 반환된 pw가 존재하면 아이디가 존재하기때문에 입력 비밀번호와 등록된 비밀번호가 일치하는지 검사
		// 비밀번호가 틀릴경우  1 반환
		else if(!member.getPw().contentEquals(usrInfo.get("pw")))
			result = "1";
		
		// 아이디가 존재하고 비밀번호가 일치하면 서비스 상태를 확인해야함
		// 서비스 상태가 0 일경우 이메일 미인증 상태이므로  2 반환 
		else if("0".contentEquals(usrInfo.get("serviceState")))
			result = "2";
			
		// 아이디가 존재하고
		// 입력한 비밀번호와 등록한 비밀번호가 일치하면서
		// 서비스 상태값도한 0이 아닐 경우 로그인 성공 처리
		else
			result = "3";
			

		return result;
	}
	
	 
	@Override
	public BfuMember getLoginSession(String usrid) {
		
		return memdao.getLoginSession(usrid);
	}
	
	@Override
	public String findIDProc(MemberAuthDTO authDTO) {
	
		return memdao.selectUsrid(authDTO);
	}
	
	
	@Override
	public List<UsrBookInfo> getUsrBookLst(String usrid) {

		List<UsrBookInfo> usrBookLst = memdao.selectUsrBookLst(usrid);

		System.out.println(usrBookLst.get(0).getAddcode());
		/*
		if (usrBookLst.get(0).getAddcode().contentEquals("none")) {
			return null;
		}
		*/
		return usrBookLst;
	}
	
	@Override
	public void modifyProc(BfuMember member) {
		memdao.updateMember(member);
		
	}
	
	@Override
	public List<Bookinfo> getBookLst_basedHis(String addcode) {
		
		List<Bookinfo> bookLst= memdao.getBookLst_basedHis(addcode);
		
		for(Bookinfo b : bookLst) {
			System.out.println(b.getTitle());
		}
		return bookLst;
	}
}
