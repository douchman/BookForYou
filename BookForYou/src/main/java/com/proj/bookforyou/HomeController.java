package com.proj.bookforyou;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.Recommend.service.IRecommendService;
import com.proj.bookforyou.service.IMainService;
import com.proj.detailpage.bookComment;
import com.proj.detailpage.bookInfo;
import com.proj.detailpage.bookSearchInfo;
import com.proj.detailpage.detailService;

/**
 * Handles requests for the application home page.
 */
@SessionAttributes({"sessionMember", "sessionLogin"})
@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IRecommendService iRecommend;
	@Autowired
	private IMainService iMainServ;
	@Autowired
	private detailService deSerV;
	
	@ModelAttribute("sessionLogin")
	public BfuMember getLoginsession() {	
		return new BfuMember();
	}
	@ModelAttribute("sessionMember")
	public BfuMember getEmptyMember() {	
		return new BfuMember();
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	*/
	@RequestMapping("main")
	public String main(Model model, @ModelAttribute("sessionLogin") BfuMember member) {
		model.addAttribute("recommend", iMainServ.recommendList(iRecommend.usrBasedRecommend(member.getUsrnickname())));
		model.addAttribute("recommendCodeList", iMainServ.recommendCodeList(member.getMaxReaderSign(), member.getMaxContentsSign()));
		return "forward:/mainPage";
	}
	@RequestMapping("detail")
	public String detail(@RequestParam("bookNo") String bookNo, Model model) {
		List<bookComment> lst = deSerV.viewReview(bookNo);
        List<bookInfo> list = deSerV.viewMore(bookNo);
        int grape1 = deSerV.grape1(bookNo);
        int grape2 = deSerV.grape2(bookNo);
        int grape3 = deSerV.grape3(bookNo);
        int grape4 = deSerV.grape4(bookNo);
        int grape5 = deSerV.grape5(bookNo);
        
		bookInfo book = deSerV.detailView(bookNo);
		model.addAttribute("bookInfo", book);
		model.addAttribute("bookComment", lst);
		model.addAttribute("viewMore", list);
		model.addAttribute("grape1", grape1);
		model.addAttribute("grape2", grape2);
		model.addAttribute("grape3", grape3);
		model.addAttribute("grape4", grape4);
		model.addAttribute("grape5", grape5);
		return "forward:/detailView";
	}
	@RequestMapping("search")
	public String search(@RequestParam("searchStr") String searchStr, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<bookSearchInfo> searchList = iMainServ.searchBook(searchStr);
		
        session.setAttribute("searchList", searchList);
        model.addAttribute("searchCount", searchList.size());
		model.addAttribute("searchStr", searchStr);
		//model.addAttribute("searchBookLst", iMainServ.searchBook(searchStr));
		return "forward:/searchBook";
	}
	
	@RequestMapping(value = "paging", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String paging(@RequestParam("page") String page, @RequestParam("searchStr") String searchStr, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		List<bookSearchInfo> bookList = (List<bookSearchInfo>)session.getAttribute("searchList");
		//List<bookSearchInfo> bookList = iMainServ.getBookList(page, searchStr);
		return iMainServ.scrollPaging(page, bookList);
	}
	
	
	
	
	@RequestMapping("dataSet")
	public String dataSet(Model model) {
		model.addAttribute("allUsrScoreList", iRecommend.allUsrScoreList());
		return "forward:/mainPage";
	}
	
	@RequestMapping("usrBasedResult")
	public String usrBasedResult(Model model) {
		String[][] similarityTable = iRecommend.usrBasedSimilarity();

		model.addAttribute("similarityTable", similarityTable);
		return "forward:/mainPage";
	}
	@RequestMapping("Recommend")
	public String Recommend(Model model) {
		List<List<bookSearchInfo>> recommendListAll = new ArrayList<List<bookSearchInfo>>();
		recommendListAll.add(iMainServ.recommendList(iRecommend.usrBasedRecommend("재석")));
		recommendListAll.add(iMainServ.recommendList(iRecommend.usrBasedRecommend("명수")));
		recommendListAll.add(iMainServ.recommendList(iRecommend.usrBasedRecommend("하하")));
		recommendListAll.add(iMainServ.recommendList(iRecommend.usrBasedRecommend("준하")));
		recommendListAll.add(iMainServ.recommendList(iRecommend.usrBasedRecommend("세형")));
		recommendListAll.add(iMainServ.recommendList(iRecommend.usrBasedRecommend("광희")));
		recommendListAll.add(iMainServ.recommendList(iRecommend.usrBasedRecommend("동관")));
		recommendListAll.add(iMainServ.recommendList(iRecommend.usrBasedRecommend("name")));
		
		model.addAttribute("usrBasedRecommend", recommendListAll);
		model.addAttribute("usrBasedRecommendAll", iRecommend.usrBasedRecommendAll());
		return "forward:/mainPage";
	}
	
	@RequestMapping("incrCount")
	public String incrCount(@RequestParam("author") String author, Model model) {
		model.addAttribute("incrCount", iMainServ.incrCount("1", author));
		return "forward:/mainPage";
	}

}
