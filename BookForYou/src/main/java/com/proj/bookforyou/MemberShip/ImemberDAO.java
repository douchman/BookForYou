package com.proj.bookforyou.MemberShip;

public interface ImemberDAO {

	public String isExistId(String usrid);

	public String isExistId(BfuMember member);
	public String isExistNickName(BfuMember member);
	public String insertMember(BfuMember member);

	
}
