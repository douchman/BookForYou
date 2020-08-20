package com.proj.bookforyou.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.bookforyou.Recommend.service.IRedis;
import com.proj.detailpage.bookSearchInfo;

@Service
public class MainServiceImpl implements IMainService{
	@Autowired
	private ISearchDAO IsearchDao;
	@Autowired
	private IRedis iRedis;
	
	@Override
	public List<bookSearchInfo> searchBook(String searchStr) {
		return IsearchDao.searchBook(searchStr);
	}
	@Override
	public List<bookSearchInfo> getBookList(String page, String searchStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageNum = Integer.parseInt(page);
		map.put("start", pageNum+(49*(pageNum-1)));
		map.put("end", pageNum*50);
		map.put("searchStr", searchStr);
		return IsearchDao.getBookList(map);
	}
	@Override
	public String scrollPaging(String page, List<bookSearchInfo> bookList) {
		return scrollPaging.scrollPage(page, bookList);
	}
	
	@Override
	public int incrCount(String usrId, String author) {
		return iRedis.incrCount(usrId, author);
	}
	
	@Override
	public List<bookSearchInfo> recommendList(String recNo) {
		return IsearchDao.recommendList(recNo.split(" "));
	}
}
