package com.proj.bookforyou.service;

import java.util.List;

import com.proj.detailpage.bookSearchInfo;

public interface IMainService {
	public List<bookSearchInfo> searchBook(String searchStr);
	public List<bookSearchInfo> getBookList(String page, String searchStr);
	public String scrollPaging(String page, List<bookSearchInfo> bookList);
}
