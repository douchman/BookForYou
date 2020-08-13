package com.proj.bookforyou;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.proj.bookforyou.Recommend.service.IRecommendService;
import com.proj.detailpage.detailService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IRecommendService iRecommend;
	@Autowired
	private detailService deSerV;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	@RequestMapping("main")
	public String main() {
		return "Mainpage/main";
	}
	@RequestMapping("detail")
	public String detail(@RequestParam("bookNo") String bookNo, Model model) {
//		iRecommend.saveData("park", bookName, "5");		//Redis�뿉 (�븘�씠�뵒, 梨낆씠由�, �젏�닔)���옣
//		Map<String, String> usrScore = iRecommend.loadData("park");		//Redis�뿉�꽌 (�븘�씠�뵒)�젙蹂� 媛��졇�샂
//		
//		Set<String> key = usrScore.keySet();
//		 
//        Iterator<String> keyIter = key.iterator();
// 
//        while (keyIter.hasNext()) {
//            System.out.println(usrScore.get(keyIter.next()));
//        }
        
		model.addAttribute("bookInfo", deSerV.detailView(bookNo));
		return "detailPage/detailPage";
	}
	@RequestMapping("search")
	public String search(@RequestParam("searchStr") String searchStr, Model model) {
		model.addAttribute("searchStr", searchStr);
		return "Mainpage/searchForm";
	}
	
	
	
	
	
	@RequestMapping("dataSet")
	public String dataSet(Model model) {
		model.addAttribute("allUsrScoreList", iRecommend.allUsrScoreList());
		return "Mainpage/main";
	}
	@RequestMapping("usrBasedResult")
	public String usrBasedResult(Model model) {
		String[][] similarityTable = iRecommend.usrBasedSimilarity();
//		for(int i=0; i<similarityTable.length; i++) {			//肄붿궗�씤 �쑀�궗�룄 寃곌낵 �솗�씤 肄붾뱶
//			for(int j=0; j<similarityTable[i].length; j++) {
//				System.out.print(String.format("%.2f", similarityTable[i][j]) + "  ");
//			}
//			System.out.println();
//		}
		List<String> usrList = iRecommend.getUsrList();
		iRecommend.saveUsrBased(similarityTable, usrList);
		model.addAttribute("similarityTable", similarityTable);
		return "Mainpage/main";
	}
}
