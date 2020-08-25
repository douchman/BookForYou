package com.proj.bookforyou.Library.DTO;

//컬렉션 테이블 
public class Collection {

 // 컬렉션 번호 
 private Integer collnum;

 // 닉네임 
 private String nickname;

 // 콜렉션 제목 
 private String colltitle;

 // 콜렉션 설명 
 private String colldesc;

 // 일련번호 
 private String masterseqlst;

 public String getMasterseqlst() {
	return masterseqlst;
}

public void setMasterseqlst(String masterseqlst) {
	this.masterseqlst = masterseqlst;
}

public Integer getCollnum() {
     return collnum;
 }

 public void setCollnum(Integer collnum) {
     this.collnum = collnum;
 }

 public String getNickname() {
     return nickname;
 }

 public void setNickname(String nickname) {
     this.nickname = nickname;
 }

 public String getColltitle() {
     return colltitle;
 }

 public void setColltitle(String colltitle) {
     this.colltitle = colltitle;
 }

 public String getColldesc() {
     return colldesc;
 }

 public void setColldesc(String colldesc) {
     this.colldesc = colldesc;
 }
 // Collection 모델 복사
 public void CopyData(Collection param)
 {
     this.collnum = param.getCollnum();
     this.nickname = param.getNickname();
     this.colltitle = param.getColltitle();
     this.colldesc = param.getColldesc();
     this.masterseqlst = param.getMasterseqlst();
 }
}