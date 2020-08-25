package com.proj.bookforyou.Recommend.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Tuple;

public interface IRedis {
	public void saveData(String usrId, String bookNo, String score);
	public Map<String, String> loadData(String usrId);
	public Double getScore(String usrId, String bookNo);
	public void saveUsr(String usrId);
	public List<String> getUsrList();
	public void saveUsrBased(String[][] similarityTable, List<String> usrList);
	public Set<Tuple> getUsrBasedSimilarity(String usrId);
	public Map<String, String> isExistBook(String usrId);
	
	public int incrCount(String usrId, String author);
}
