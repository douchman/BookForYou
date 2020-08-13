package com.proj.bookforyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.detailpage.bookSearchInfo;

@Service
public class MainServiceImpl implements IMainService{
	@Autowired
	private ISearchDAO IsearchDao;
	
	@Override
	public List<bookSearchInfo> searchBook(String searchStr) {
		return IsearchDao.searchBook(searchStr);
	}
}
