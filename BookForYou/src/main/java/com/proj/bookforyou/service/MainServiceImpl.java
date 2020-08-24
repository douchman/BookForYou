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
	
	public static String[] shuffle(String[] arr){
		for(int x=0;x<arr.length;x++){
			int i = (int)(Math.random()*arr.length);
			int j = (int)(Math.random()*arr.length);
			
			String tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		return arr;
	}
	
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
		String[] random_recommend = shuffle(recNo.split(" "));
		
		return IsearchDao.recommendList(random_recommend);
	}
}
