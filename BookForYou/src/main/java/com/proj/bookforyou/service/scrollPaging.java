package com.proj.bookforyou.service;

import java.util.List;

import com.proj.detailpage.bookSearchInfo;

public class scrollPaging {
	public static String scrollPage(String page,List<bookSearchInfo> bookList) {
		String bookLst = "";
		int pageNum = Integer.parseInt(page);
		int startNum = pageNum+(48*(pageNum-1));
		int endNum = pageNum*49;
		
		for(int i=startNum; i<endNum; i++) {
			if(bookList.size() > i) {
				bookLst += "<div class='col-sm-12 col-md-1'>";
				bookLst += "<div class='book' onclick='detail(" + bookList.get(i).getMasterseq() + ");'>";
				bookLst += "<input type='hidden' class='bookNo' value='" + bookList.get(i).getMasterseq() + "'/>";
				bookLst += "<img style='width: 130; height: 200px;' src='" + bookList.get(i).getImgurl() + "' alt='...'>";
				bookLst += "<div class='caption'>";
				bookLst += "<p style='font-size: medium;'>" + bookList.get(i).getTitle() + "</p>";
				bookLst += "</div>";
				bookLst += "<div class='captionRating'>";
				bookLst += "<b style='font-size: small;'>평점 5.0</b>";
				bookLst += "</div>";
				bookLst += "</div>";
				bookLst += "</div>";
			}
		}
		
		return bookLst;
	}
}
