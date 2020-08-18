package com.proj.detailpage;

public interface detailService {
	public bookInfo detailView(String bookNo);
	
	public void indvRating(String rating, String nickName, String masterSeq);
	public void wishBookList(String nickName, String masterSeq);
	public void deleteRating(String nickName);
	public void deleteWish(String nickName);
}
