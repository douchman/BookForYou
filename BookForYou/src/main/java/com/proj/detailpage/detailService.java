package com.proj.detailpage;

import java.util.List;

public interface detailService {
	public bookInfo detailView(String bookNo);
	
	public int ratingCheck(String nickName, String masterSeq);
	public void indvRating(String rating, String nickName, String masterSeq);
	public void ratingUpdate(String rating, String nickName, String masterSeq);
	public int wishCheck(String nickName, String masterSeq);
	public void wishBookList(String nickName, String masterSeq);
	public void deleteRating(String nickName, String masterSeq);
	public void deleteWish(String nickName, String masterSeq);
	
	public void writeReview(bookComment bookcomment);
	
	public List<bookComment> viewReview(String bookNo);
	
	public void likeReview(String nickName, String commentNum);
	public void likedelete(String nickName, String commentNum);
	public int likeCheck(String nickName, String commentNum);
	public void likeAdd(int commentNum);
	public void likeSubtract(int commentNum);
	
	public List<bookInfo> viewMore(String bookNo);
	
	public int grape1(String bookNo);
	public int grape2(String bookNo);
	public int grape3(String bookNo);
	public int grape4(String bookNo);
	public int grape5(String bookNo);
}
