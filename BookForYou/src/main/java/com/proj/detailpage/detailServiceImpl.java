package com.proj.detailpage;

import java.util.HashMap;
import java.util.List;
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
	public int ratingCheck(String nickName, String masterSeq) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("masterSeq", Integer.parseInt(masterSeq));
		map.put("nickName", nickName);
		
		System.out.println("ratingCheck : " + map);
		return iDao.ratingCheck(map);
	}
	
	@Override
	public void ratingUpdate(String rating, String nickName, String masterSeq) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("rating", Double.parseDouble(rating));
		map.put("nickName", nickName);
		map.put("masterSeq",Integer.parseInt(masterSeq));
		
		System.out.println("ratingUpdate : " + map);
		iDao.ratingUpdate(map);
		
	}
	
	@Override
	public void indvRating(String rating, String nickName, String masterSeq){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("rating", Double.parseDouble(rating));
		map.put("nickName", nickName);
		map.put("masterSeq",Integer.parseInt(masterSeq));
		
		System.out.println("indvRating : " + map);
		iDao.indvRating(map);
	}

	@Override
	public int wishCheck(String nickName, String masterSeq) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("masterSeq", Integer.parseInt(masterSeq));
		map.put("nickName", nickName);
		
		System.out.println("wishCheck : " + map);
		return iDao.wishCheck(map);
	}
	
	@Override
	public void wishBookList(String nickName, String masterSeq) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("nickName", nickName);
		map.put("masterSeq",Integer.parseInt(masterSeq));
		
		System.out.println("wishBookList : " + map);
		iDao.wishBookList(map);
		
	}

	@Override
	public void deleteRating(String nickName, String masterSeq) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("nickName", nickName);
		map.put("masterSeq",Integer.parseInt(masterSeq));
		
		System.out.println("deleteRating : " + map);
		iDao.deleteRating(map);
		
	}

	@Override
	public void deleteWish(String nickName, String masterSeq) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("nickName", nickName);
		map.put("masterSeq",Integer.parseInt(masterSeq));
		
		System.out.println("deleteWish : " + map);
		iDao.deleteWish(map);
		
	}

	@Override
	public void writeReview(bookComment bookcomment) {
	
		System.out.println(bookcomment.getNickname());
		System.out.println(bookcomment.getReview());
		System.out.println(bookcomment.getMasterseq());
		iDao.writeReview(bookcomment);
	}

	@Override
	public List<bookComment> viewReview(String bookNo) {
		return iDao.viewReview(Integer.parseInt(bookNo));
	}
	
	@Override
	public List<bookInfo> viewMore(String bookNo) {
		return iDao.viewMore(Integer.parseInt(bookNo));
	}


	@Override
	public void likeReview(String nickName, String commentNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickName", nickName);
		map.put("commentNum", Integer.parseInt(commentNum));
		
		System.out.println("likeReview : " + map);
		iDao.likeReview(map);
	}

	@Override
	public int likeCheck(String nickName, String commentNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentNum", Integer.parseInt(commentNum));
		map.put("nickName", nickName);
		
		System.out.println("likeCheck : " + map);
		return iDao.likeCheck(map);
	}

	@Override
	public void likeAdd(int commentNum) {
		System.out.println("likeAdd : " + commentNum);
		iDao.likeAdd(commentNum);
	}

	@Override
	public void likeSubtract(int commentNum) {
		System.out.println("likeSubtract : " + commentNum);
		iDao.likeSubtract(commentNum);
	}

	@Override
	public void likedelete(String nickName, String commentNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentNum", Integer.parseInt(commentNum));
		map.put("nickName", nickName);
		
		System.out.println("likedelete : " + map);
		iDao.likedelete(map);
		
	}
     
	// 책 부가코드 가져오기
	@Override
	public String getAddCode(int seqNum) {
		
		String addcode = iDao.getAddCode(seqNum);
		
		addcode = addcode.substring(2,3);
		return addcode;
	}
	
	@Override
	public int grape1(String bookNo) {
		return iDao.grape1(Integer.parseInt(bookNo));
	}
	@Override
	public int grape2(String bookNo) {
		return iDao.grape2(Integer.parseInt(bookNo));
	}
	@Override
	public int grape3(String bookNo) {
		return iDao.grape3(Integer.parseInt(bookNo));
	}
	@Override
	public int grape4(String bookNo) {
		return iDao.grape4(Integer.parseInt(bookNo));
	}
	@Override
	public int grape5(String bookNo) {
		return iDao.grape5(Integer.parseInt(bookNo));
	}
}
