package com.proj.bookforyou.TendsAnalysis.service;

import java.util.List;

import com.proj.bookforyou.MemberShip.BfuMember;
import com.proj.bookforyou.MemberShip.UsrBookInfo;

public interface ITendsAnalysisService {
	public void setUsrBookLst(List<UsrBookInfo> usrBookLst, BfuMember member);
	public void divideLst();
	public void setSignCntMap();
	public void calMaxSignValue();
	public BfuMember getResult(List<UsrBookInfo> usrBookLst, BfuMember member);
}
