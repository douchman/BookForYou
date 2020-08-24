package com.proj.bookforyou.service;

import java.util.List;
import java.util.Map;

import com.proj.detailpage.bookSearchInfo;

public interface ISearchDAO {
	public List<bookSearchInfo> searchBook(String searchStr);
	public List<bookSearchInfo> getBookList(Map<String, Object> map);
	
	public List<bookSearchInfo> recommendList(String[] recNo);
}
