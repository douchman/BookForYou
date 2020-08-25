package com.proj.detailpage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			@RequestParam("masterSeq") String masterSeq,
			@RequestParam("addcode")String addcode) {
		System.out.println(nickName);
		System.out.println(rating);
		System.out.println(masterSeq);
		
		if(deSerV.ratingCheck(nickName, masterSeq) == 0) {
			deSerV.indvRating(rating, nickName, masterSeq,addcode);
			deSerV.deleteWish(nickName, masterSeq);
		}
		else {
			deSerV.ratingUpdate(rating, nickName, masterSeq);
		}
		//iRecommend.saveData(nickName, masterSeq, rating);
		
		bookInfo book = deSerV.detailView(masterSeq);
		model.addAttribute("bookInfo", book);
		return "redirect:/detail?bookNo=" + masterSeq;
	}
	
	@RequestMapping("wish")
	public String wish(Model model, @RequestParam("wish") String wish, @RequestParam("masterSeq") String masterSeq,  @RequestParam("nickName") String nickName) {
		if(deSerV.wishCheck(nickName, masterSeq) == 0) {
			bookInfo book = deSerV.detailView(masterSeq);
			model.addAttribute("bookInfo", book);
			deSerV.wishBookList(nickName, masterSeq);
			deSerV.deleteRating(nickName, masterSeq);
		}
		else {
			deSerV.deleteWish(nickName, masterSeq);
		}
		System.out.println(wish);
		System.out.println(masterSeq);
		System.out.println(nickName);
		
		return "redirect:/detail?bookNo=" + masterSeq;
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
		model.addAttribute("bookComment",bookcomment);
		deSerV.writeReview(bookcomment);
		return "detailPage/writeReviewDone";
	}
	
	@RequestMapping("modifyReview")
	public String modifyReview() {
		return "detailPage/modifyReview";
	}
	
	//modify �߰��ؾ���
	
	
	@RequestMapping("like")
	public String like(Model  model,@RequestParam("nickName") String nickName, @RequestParam("commentNum") String commentNum) {
		
		System.out.println(nickName);
		System.out.println(commentNum);
		System.out.println(deSerV.likeCheck(nickName, commentNum));
		
		if(deSerV.likeCheck(nickName, commentNum) == 0) {
			deSerV.likeReview(nickName, commentNum);
			deSerV.likeAdd(Integer.parseInt(commentNum));
			}
		else {
			deSerV.likedelete(nickName, commentNum);
			deSerV.likeSubtract(Integer.parseInt(commentNum));
		}
		return "detailPage/detailPage";
	}
}
