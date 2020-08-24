package com.proj.bookforyou.Library.DTO;

//읽고싶어요 테이블 
public class Wishbooklist {
	// 닉네임
	private String nickname;
	// 일련번호
	private Integer masterseq;
	private String title;
	private String imgurl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getMasterseq() {
		return masterseq;
	}

	public void setMasterseq(Integer masterseq) {
		this.masterseq = masterseq;
	}

	// Wishbooklist 모델 복사
	public void CopyData(Wishbooklist param) {
		this.nickname = param.getNickname();
		this.masterseq = param.getMasterseq();
	}
}