package com.proj.detailpage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.bookforyou.Recommend.service.IRecommendService;

@RequestMapping("detail")
@Controller
public class detailController {
	private static final Logger logger = LoggerFactory.getLogger(detailController.class);
	@Autowired
	private detailService deSerV;
	@Autowired
	private IRecommendService iRecommend;
	 
	@RequestMapping("indivRating")
	public String indivRating(Model model, @RequestParam("nickName") String nickName, 
			@RequestParam("rating") String rating,
			@RequestParam("masterSeq") String masterSeq) {
		System.out.println(nickName);
		System.out.println(rating);
		System.out.println(masterSeq);
		
		deSerV.indvRating(rating, nickName, masterSeq);
		deSerV.deleteWish(nickName, masterSeq);
		
		iRecommend.saveData(nickName, masterSeq, rating);
		
		bookInfo book = deSerV.detailView(masterSeq);
		model.addAttribute("bookInfo", book);
		return "detailPage/detailPage";
	}
	
	@RequestMapping("wish")
	public String wish(Model model, @RequestParam("wish") String wish, @RequestParam("masterSeq") String masterSeq,  @RequestParam("nickName") String nickName) {
		if(wish.contentEquals("1")) {
			bookInfo book = deSerV.detailView(masterSeq);
			model.addAttribute("bookInfo", book);
			deSerV.wishBookList(nickName, masterSeq);
			deSerV.deleteRating(nickName, masterSeq);
		}
		System.out.println(wish);
		System.out.println(masterSeq);
		System.out.println(nickName);
		
		return "detailPage/detailPage";
	}
	
	@RequestMapping("writeReview")
	public String writeReview() {
		return "detailPage/writeReview";
	}
	

	
	@RequestMapping("write")
	public String write(bookComment bookcomment, Model model) {
		System.out.println(bookcomment.getNickname());
		System.out.println(bookcomment.getReview());
		System.out.println(bookcomment.getMasterseq());
		model.addAttribute(bookcomment);
		deSerV.writeReview(bookcomment);
		return "detailPage/detailPage";
	}
}
