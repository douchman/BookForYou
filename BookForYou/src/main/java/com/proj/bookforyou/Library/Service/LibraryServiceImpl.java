package com.proj.bookforyou.Library.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.bookforyou.Library.DTO.Bookinfo;
import com.proj.bookforyou.Library.DTO.Collection;
import com.proj.bookforyou.Library.DTO.Indvbookrating;
import com.proj.bookforyou.Library.DTO.Wishbooklist;
import com.proj.bookforyou.Library.IDAO.IDAO;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	private static final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);
	
	@Autowired
	private IDAO iDao;
	
	@Override
	public List<Indvbookrating> bookRating(String usrnickname) {
		return  iDao.bookRating(usrnickname);
	}

	@Override
	public List<Wishbooklist> wishBook(String usrnickname) {
		return iDao.wishBook(usrnickname);
	}

	@Override
	public List<Bookinfo> searchBookinfo(String title) {
		return iDao.searchBookinfo(title);
	}

	@Override
	public void createCollectionProc(Collection collection) {
		iDao.createCollectionProc(collection);
		logger.info("저장 성공");
	}

	@Override
	public List<Collection> collectionInfo() {
		return iDao.collectionInfo();
	}
	
	


}
