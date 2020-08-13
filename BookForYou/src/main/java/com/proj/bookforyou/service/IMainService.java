package com.proj.bookforyou.service;

import java.util.List;

import com.proj.detailpage.bookSearchInfo;

public interface IMainService {
	public List<bookSearchInfo> searchBook(String searchStr);
}
