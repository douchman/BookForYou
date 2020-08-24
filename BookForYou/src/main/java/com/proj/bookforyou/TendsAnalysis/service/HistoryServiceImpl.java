package com.proj.bookforyou.TendsAnalysis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.proj.bookforyou.MemberShip.usrBookHistory;

@Service
public class HistoryServiceImpl implements IHistoryService {

	
	// 내용분류1 기호 값 카운트 리스트
	Map<String, Integer> contentsSignCntMap;
		
	// 분할된 내용분류1 기호 저장 리스트
	List<usrBookHistory> contentsSignLst;

	//최대 기호값이 저장될 Map Entry
	Map.Entry<String, Integer> maxContentsSignEntry = null;
		
	public HistoryServiceImpl() {
		contentsSignCntMap = new HashMap<String, Integer>();
		contentsSignLst = new ArrayList<usrBookHistory>();
	}

	@Override
	public String setHistoryLst( ArrayList<usrBookHistory> contentSignLst) {
		this.contentsSignLst = contentSignLst;
		//System.out.println(contentsSignLst);
		return setSignCntMap();
	}
	
	@Override
	public String setSignCntMap() {
		for(usrBookHistory contentsign : this.contentsSignLst) {
			contentsSignCntMap.put(contentsign.getAddCode(), contentsSignCntMap.getOrDefault(contentsign, 0)+1);
			
		}
		
		return calMaxSignValue();
	}
	
	@Override
	public String calMaxSignValue() {
		for(Map.Entry<String, Integer> entry : contentsSignCntMap.entrySet()) {
			if(maxContentsSignEntry == null || entry.getValue().compareTo(maxContentsSignEntry.getValue())>0) {
				maxContentsSignEntry = entry;
			}
		}
		
		return maxContentsSignEntry.getKey();		
	}

}
