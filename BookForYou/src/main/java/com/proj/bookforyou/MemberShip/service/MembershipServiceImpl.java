package com.proj.bookforyou.MemberShip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.MemberShip.ImemberDAO;

import Mail.AuthnumGenerator;
import Mail.ParkMail;

@Service
public class MembershipServiceImpl implements IMembershipService {


		
	@Autowired
	private ImemberDAO memdao;

	@Override
	public String isExistId(BfuMember member) {
		// id가 이미 있을경우에는 1 없을경우에는 0 를 반환한다.
		System.out.println("serv chk");

		return memdao.isExistId(member);
	}

	@Override
	public String isExistNickName(BfuMember member) {

		return memdao.isExistNickName(member);
	}

	@Override
	public String memberProc(BfuMember member) {
		/*
		parkmail.sendMail(member.getUsrid(), 
				"인증메일 테스트", 
				"인증번호" + authNumGen.getAuthNum());
		*/
		//memdao.insertMember(member);
		
		return null;
	}
}
