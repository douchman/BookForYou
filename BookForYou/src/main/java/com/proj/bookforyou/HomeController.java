package com.proj.bookforyou;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IRecommendService iRecommend;
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
	public String detail(@RequestParam("bookName") String bookName, Model model) {
		iRecommend.saveData("park", bookName, "5");		//Redis에 (아이디, 책이름, 점수)저장
		Map<String, String> usrScore = iRecommend.loadData("Park");		//Redis에서 (아이디)정보 가져옴
		
		Set<String> key = usrScore.keySet();
		 
        Iterator<String> keyIter = key.iterator();
 
        while (keyIter.hasNext()) {
            System.out.println(usrScore.get(keyIter.next()));
        }
        
		model.addAttribute("bookName", bookName);
		return "detailPage/detailPage";
	}
	@RequestMapping("search")
	public String search(@RequestParam("searchStr") String searchStr, Model model) {
		model.addAttribute("searchStr", searchStr);
		return "Mainpage/searchForm";
	}
}
