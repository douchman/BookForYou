package com.proj.bookforyou.Library.DTO;

//책 정보 DB 
public class Bookinfo {

 // 일련번호 
 private Integer masterseq;

 // ISBN13 
 private String isbn13;

 // 볼륨 
 private String vol;

 // 제목 
 private String title;

 // 저자 
 private String author;

 // 출판사 
 private String publisher;

 // 발행일자 
 private String pubdate;

 // 부가기호 
 private String addcode;

 // 가격 
 private String price;

 // 이미지 URL 
 private String imgurl;

 // 책 소개 
 private String description;

 public Integer getMasterseq() {
     return masterseq;
 }

 public void setMasterseq(Integer masterseq) {
     this.masterseq = masterseq;
 }

 public String getIsbn13() {
     return isbn13;
 }

 public void setIsbn13(String isbn13) {
     this.isbn13 = isbn13;
 }

 public String getVol() {
     return vol;
 }

 public void setVol(String vol) {
     this.vol = vol;
 }

 public String getTitle() {
     return title;
 }

 public void setTitle(String title) {
     this.title = title;
 }

 public String getAuthor() {
     return author;
 }

 public void setAuthor(String author) {
     this.author = author;
 }

 public String getPublisher() {
     return publisher;
 }

 public void setPublisher(String publisher) {
     this.publisher = publisher;
 }

 public String getPubdate() {
     return pubdate;
 }

 public void setPubdate(String pubdate) {
     this.pubdate = pubdate;
 }

 public String getAddcode() {
     return addcode;
 }

 public void setAddcode(String addcode) {
     this.addcode = addcode;
 }

 public String getPrice() {
     return price;
 }

 public void setPrice(String price) {
     this.price = price;
 }

 public String getImgurl() {
     return imgurl;
 }

 public void setImgurl(String imgurl) {
     this.imgurl = imgurl;
 }

 public String getDescription() {
     return description;
 }

 public void setDescription(String description) {
     this.description = description;
 }

 // Bookinfo 모델 복사
 public void CopyData(Bookinfo param)
 {
     this.masterseq = param.getMasterseq();
     this.isbn13 = param.getIsbn13();
     this.vol = param.getVol();
     this.title = param.getTitle();
     this.author = param.getAuthor();
     this.publisher = param.getPublisher();
     this.pubdate = param.getPubdate();
     this.addcode = param.getAddcode();
     this.price = param.getPrice();
     this.imgurl = param.getImgurl();
     this.description = param.getDescription();
 }
}