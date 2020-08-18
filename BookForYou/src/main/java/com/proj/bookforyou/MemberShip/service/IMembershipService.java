package com.proj.bookforyou.MemberShip.service;

import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.MemberShip.MemberAuthDTO;

public interface IMembershipService {

	public String isExistId(BfuMember member);
	public String isExistNickName(BfuMember member);
	public String memberProc(BfuMember member);
	public boolean authProc(MemberAuthDTO authDTO);
	public String loginProc(BfuMember member);
	public BfuMember getLoginSession(String usrid);
	public String findIDProc(MemberAuthDTO authDTO);
}
