package com.proj.bookforyou.Recommend.service;

import java.util.Map;

public interface IRecommendService {
	public void saveData(String usrId, String bookName, String score);
	public Map<String, String> loadData(String usrId);
}
