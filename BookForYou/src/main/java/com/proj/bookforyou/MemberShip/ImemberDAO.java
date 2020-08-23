package com.proj.bookforyou.MemberShip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ImemberDAO {

	public String isExistId(String usrid);

	public String isExistId(BfuMember member);
	public String isExistNickName(BfuMember member);
	public void insertMember(BfuMember member);
	public String selectUsrAuthNum(MemberAuthDTO authDTO);
	public void updateMemberState(MemberAuthDTO authDTO);
	public HashMap<String, String> selectUsrinfo(BfuMember member);
	public BfuMember getLoginSession(String usrid);
	public String selectUsrid(MemberAuthDTO authDTO);
	public List<UsrBookInfo> selectUsrBookLst(String usrid);
	public void updateMember(BfuMember member);

	
}
