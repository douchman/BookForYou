package com.proj.bookforyou.MemberShip;

//회원정보 
public class BfuMember {

	// 유저아이디(이메일)
	private String usrid;

	// 별명
	private String usrnickname;

	// 비밀번호
	private String pw;

	// 성별
	private String gender;

	// 연령
	private Integer age;

	// 선호카테고리
	private String favorite;

	// 선호카테고리2
	private String favorite2;

	// 선호카테고리3
	private String favorite3;

	//서비스상태 
	private String servicestate;

	// 인증번호 
	private String usrauthnum;

	
	// ID 와 닉네임 쿼리결과값 임시 저장 
	private String idQueryRes;

	private String nicknameQueryRes;

	
	
	public String getNicknameQueryRes() {
		return nicknameQueryRes;
	}

	public void setNicknameQueryRes(String nicknameQueryRes) {
		this.nicknameQueryRes = nicknameQueryRes;
	}

	
	public String getIdQueryRes() {
		return idQueryRes;
	}

	public void setIdQueryRes(String idQueryRes) {
		this.idQueryRes = idQueryRes;
	}

	public String getServicestate() {
		return servicestate;
	}

	public void setServicestate(String servicestate) {
		this.servicestate = servicestate;
	}

	public String getUsrauthnum() {
		return usrauthnum;
	}

	public void setUsrauthnum(String usrauthnum) {
		this.usrauthnum = usrauthnum;
	}

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public String getFavorite2() {
		return favorite2;
	}

	public void setFavorite2(String favorite2) {
		this.favorite2 = favorite2;
	}

	public String getFavorite3() {
		return favorite3;
	}

	public void setFavorite3(String favorite3) {
		this.favorite3 = favorite3;
	}

}