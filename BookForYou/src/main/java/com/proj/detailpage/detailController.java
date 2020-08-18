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
			@RequestParam("masterSeq") String masterSeq/* , @RequestParam("wish") String wish */) {
		deSerV.indvRating(rating, nickName, masterSeq);
		System.out.println(nickName);
		System.out.println(rating);
		System.out.println(masterSeq);
		//System.out.println(wish);
		
		//iRecommend.saveData(nickName, masterSeq, rating);
		
		bookInfo book = deSerV.detailView(masterSeq);
		model.addAttribute("bookInfo", book);
		model.addAttribute("rating", rating);
		return "detailPage/detailPage";
	}
}
