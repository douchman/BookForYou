package com.proj.bookforyou.Recommend.service;

<<<<<<< HEAD
public interface IRecommendService {

=======
import java.util.List;
import java.util.Map;

public interface IRecommendService {
	public void saveData(String usrId, String bookName, String score);
	public Map<String, String> loadData(String usrId);
	public void saveUsr(String usrId);
	public List<String> getUsrList();
	public List<List<String>> allUsrScoreList();
	public String[][] usrBasedSimilarity();
	public double[][] itemBasedSimilarity();
	public void saveUsrBased(String[][] similarityTable, List<String> usrList);
>>>>>>> master
}
