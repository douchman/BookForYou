package com.proj.detailpage;

import java.util.Map;

public interface IDAO {
	public bookInfo detailView(int bookNo);
	
	public void indvRating(Map<String, Object> map);
	public void wishBookList(Map<String, Object> map);
	public void deleteRating(Map<String, Object> map);
	public void deleteWish(Map<String, Object> map);

	public void writeReview(bookComment bookcomment);
	
}
