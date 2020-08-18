package com.proj.detailpage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class detailServiceImpl implements detailService{
	@Autowired
	private IDAO iDao;
	
	@Override
	public bookInfo detailView(String bookNo) {
		return iDao.detailView(Integer.parseInt(bookNo));
	}

	@Override
	public void indvRating(String rating, String nickName, String masterSeq){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("rating", Double.parseDouble(rating));
		map.put("nickName", nickName);
		map.put("masterSeq",Integer.parseInt(masterSeq));
		
		System.out.println(map);
		iDao.indvRating(map);
	}

	@Override
	public void wishBookList(String nickName, String masterSeq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRating(String nickName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWish(String nickName) {
		// TODO Auto-generated method stub
		
	}

}
