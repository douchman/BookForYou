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
import com.proj.bookforyou.service.IMainService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IRecommendService iRecommend;
	@Autowired
	private IMainService iMainServ;
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
//		iRecommend.saveData("park", bookName, "5");		//Redis에 (아이디, 책이름, 점수)저장
//		Map<String, String> usrScore = iRecommend.loadData("park");		//Redis에서 (아이디)정보 가져옴
//		
//		Set<String> key = usrScore.keySet();
//		 
//        Iterator<String> keyIter = key.iterator();
// 
//        while (keyIter.hasNext()) {
//            System.out.println(usrScore.get(keyIter.next()));
//        }
        
		model.addAttribute("bookNo", bookNo);
		return "detailPage/detailPage";
	}
	@RequestMapping("search")
	public String search(@RequestParam("searchStr") String searchStr, Model model) {
		model.addAttribute("searchStr", searchStr);
		model.addAttribute("searchBookLst", iMainServ.searchBook(searchStr));
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
//		for(int i=0; i<similarityTable.length; i++) {			//코사인 유사도 결과 확인 코드
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
	@RequestMapping("Recommend")
	public String Recommend(Model model) {
		model.addAttribute("usrBasedRecommend", iRecommend.usrBasedRecommend());
		return "Mainpage/main";
	}
}
