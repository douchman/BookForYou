package com.proj.detailpage;

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

}
