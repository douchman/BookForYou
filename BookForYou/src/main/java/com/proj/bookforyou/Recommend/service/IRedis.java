package com.proj.bookforyou.Recommend.service;

import java.util.List;
import java.util.Map;

public interface IRedis {
	public void saveData(String usrId, String bookName, String score);
	public Map<String, String> loadData(String usrId);
	public void saveUsr(String usrId);
	public List<String> getUsrList();
	public void saveUsrBased(String[][] similarityTable, List<String> usrList);
}
