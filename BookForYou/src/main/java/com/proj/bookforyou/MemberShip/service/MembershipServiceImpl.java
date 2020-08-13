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
		
		AuthnumGenerator auth = new AuthnumGenerator();
		
		// 여기서 Authnum 을 생성해서 테이블에 올려놓고
		// 메일 전송 페이지로 함께 보낸다.
		
		String authNum = auth.getAuthNum();
		System.out.println("생성된 인증번호 : " + authNum);
		//memdao.insertMember(member);
		
		return authNum;
	}
}
