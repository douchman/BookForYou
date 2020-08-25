package com.proj.bookforyou.Recommend.service;


import java.util.List;
import java.util.Map;

public interface IRecommendService {
	public void saveData(String usrId, String bookNo, String score);

	public Map<String, String> loadData(String usrId);

	public void saveUsr(String usrId);

	public List<String> getUsrList();

	public List<List<String>> allUsrScoreList();

	public String[][] usrBasedSimilarity();
	
	public String usrBasedRecommend(String usrId);

	public List<List<String>> usrBasedRecommendAll();

	public void saveUsrBased(String[][] similarityTable, List<String> usrList);
	
	public Map<String, String> isExistBook(String usrId);

}