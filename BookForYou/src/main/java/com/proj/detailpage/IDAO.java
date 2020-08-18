package com.proj.detailpage;

import java.util.Map;

public interface IDAO {
	public bookInfo detailView(int bookNo);
	
	public void indvRating(Map<String, Object> map);
	public void wishBookList(Map<String, Object> map);
	public void deleteRating(String nickName);
	public void deleteWish(String nickName);
}
