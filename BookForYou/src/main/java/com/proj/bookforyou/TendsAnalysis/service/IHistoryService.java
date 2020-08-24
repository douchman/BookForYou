package com.proj.bookforyou.TendsAnalysis.service;

import java.util.ArrayList;

import com.proj.bookforyou.MemberShip.usrBookHistory;

public interface IHistoryService {
	
	
	public String setHistoryLst(ArrayList<usrBookHistory> contentSignLst);
	public String setSignCntMap();
	public String calMaxSignValue();

}
