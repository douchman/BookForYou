package com.proj.bookforyou.Library.DTO;

//개인 책 평점 
public class Indvbookrating {
// 식별번호 
	private Integer rno;
// 닉네임 
	private String nickname;
// 일련번호
	private Integer masterseq;
// 평점 
	private int rating;
	private String title;

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

	private String imgurl;
// 읽고싶어요 
	private Integer wishbooklist;

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Integer getWishbooklist() {
		return wishbooklist;
	}

	public void setWishbooklist(Integer wishbooklist) {
		this.wishbooklist = wishbooklist;
	}
}