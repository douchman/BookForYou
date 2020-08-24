package com.proj.bookforyou.Library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.proj.bookforyou.Library.DTO.Bookinfo;
import com.proj.bookforyou.Library.DTO.Collection;
import com.proj.bookforyou.Library.DTO.Indvbookrating;
import com.proj.bookforyou.Library.DTO.Wishbooklist;
import com.proj.bookforyou.Library.Service.LibraryService;
import com.proj.bookforyou.MemberShip.BfuMember;

@SessionAttributes({"sessionMember", "sessionLogin","loginState"})
@RequestMapping("Library")
@Controller
public class LibraryController {
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
	
	@Autowired
	private LibraryService liServ;
	
	
	@ModelAttribute("sessionLogin")
	public BfuMember getLoginsession() {	
		return new BfuMember();
	}
	
	
	@RequestMapping("bookRating")
	public String bookRatedView(@ModelAttribute("sessionLogin") BfuMember member,Model model) {
		System.out.println("라이브러리 유저"+member.getUsrnickname());
		
		List<Indvbookrating> ratingLst = liServ.bookRating(member.getUsrnickname());
		
		model.addAttribute("ratingLst", ratingLst);
		
		return "forward:/GoLibrary";
	}
	
	@RequestMapping("bookRatingDetail")
	public String ratedBooks(@ModelAttribute("sessionLogin") BfuMember member,Model model) {
		List<Indvbookrating> ratingLst = liServ.bookRating(member.getUsrnickname());
		
		model.addAttribute("ratingLst", ratingLst);
		
		return "forward:/gobookRatingDetail";
	}
	@RequestMapping("wishBook")
	public String ratedListView(@ModelAttribute("sessionLogin") BfuMember member,Model model) {
		List<Wishbooklist> wishBookLst = liServ.wishBook(member.getUsrnickname());
		model.addAttribute("wishBookLst", wishBookLst);
		
		return "forward:/gowishBook";
	}
	@RequestMapping("collList")
	public String collectionListView(Model model) { 
		List<Collection> collectionLst =liServ.collectionInfo();
		model.addAttribute("collectionLst", collectionLst);

		return "forward:/collList";
	}
	@RequestMapping("collForm")
	public String createCollection(Model model) { 
		
		return "forward:/collForm";
	}
	@RequestMapping("collView")
	public String collectionDetail(Model model) { 
		List<Collection> collectionList = liServ.collectionInfo();
		model.addAttribute("collectionList", collectionList);
		
		return "forward:/collView";
	}



	@RequestMapping("searchBookinfo")
	public String searchBookinfo(@RequestParam("title") String title, Model model) {
		
		model.addAttribute("bookInfoLst", liServ.searchBookinfo(title));
		
		return "forward:/collForm";
	}
	
	@RequestMapping("insertProc")
	public String createCollectionProc(Collection collection) {
		liServ.createCollectionProc(collection);
		logger.info(collection.getColltitle());
		logger.info(collection.getNickname());
		return "redirect:/collView";
	}

}
