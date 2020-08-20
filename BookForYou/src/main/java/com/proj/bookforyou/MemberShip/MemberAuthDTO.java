package com.proj.bookforyou.MemberShip;

public class MemberAuthDTO {

	private String usrid;
	private String pw;
	private String authNum;
	private String usrnickname;
	
	public String getUsrnickname() {
		return usrnickname;
	}
	public void setUsrnickname(String usrnickname) {
		this.usrnickname = usrnickname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUsrid() {
		return usrid;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	public String getAuthNum() {
		return authNum;
	}
	public void setAuthNum(String authNum) {
		this.authNum = authNum;
	}
	
}
