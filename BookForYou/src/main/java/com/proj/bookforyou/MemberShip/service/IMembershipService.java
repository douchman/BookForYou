package com.proj.bookforyou.MemberShip.service;

import java.util.List;
import java.util.Map;

import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.MemberShip.MemberAuthDTO;
import com.proj.bookforyou.MemberShip.UsrBookInfo;

public interface IMembershipService {

	public String isExistId(BfuMember member);
	public String isExistNickName(BfuMember member);
	public String memberProc(BfuMember member);
	public boolean authProc(MemberAuthDTO authDTO);
	public String loginProc(BfuMember member);
	public BfuMember getLoginSession(String usrid);
	public String findIDProc(MemberAuthDTO authDTO);
	public List<UsrBookInfo> getUsrBookLst(String usrid);
}
