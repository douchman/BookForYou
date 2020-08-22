package com.proj.detailpage;

import java.util.List;
import java.util.Map;

public interface IDAO {
	public bookInfo detailView(int bookNo);
	
	public int ratingCheck(Map<String, Object> map);
	public void indvRating(Map<String, Object> map);
	public void ratingUpdate(Map<String, Object> map);
	public int wishCheck(Map<String, Object> map);
	public void wishBookList(Map<String, Object> map);
	public void deleteRating(Map<String, Object> map);
	public void deleteWish(Map<String, Object> map);

	public void writeReview(bookComment bookcomment);
	
	public List<bookComment> viewReview(int bookNo);
	
	public void likeReview(Map<String, Object> map);
	public void likedelete(Map<String, Object> map);
	public int likeCheck(Map<String, Object> map);
	public void likeAdd(int commentNum);
	public void likeSubtract(int commentNum);
	
	public List<bookInfo> viewMore(int bookNo);
	
	public int grape1(int bookNo);
	public int grape2(int bookNo);
	public int grape3(int bookNo);
	public int grape4(int bookNo);
	public int grape5(int bookNo);
}
