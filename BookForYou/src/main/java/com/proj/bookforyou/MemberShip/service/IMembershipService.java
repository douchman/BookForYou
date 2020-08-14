package com.proj.bookforyou.MemberShip.service;

import com.proj.bookforyou.MemberShip.BfuMember;

public interface IMembershipService {

	public String isExistId(BfuMember member);
	public String isExistNickName(BfuMember member);
	public String memberProc(BfuMember member);
}
