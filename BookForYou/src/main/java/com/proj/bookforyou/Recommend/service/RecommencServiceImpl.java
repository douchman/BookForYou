package com.proj.bookforyou.Recommend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommencServiceImpl implements IRecommendService {
	@Autowired
	private IRedis iDao;

	
	public static double similarity(List<Double> vec1, List<Double> vec2) {
		double dop = 0;
		for (int n = 0; n < vec1.size(); n++)
			dop += vec1.get(n) * vec2.get(n);

		double mag1 = 0.0, mag2 = 0.0;
		for (int n = 0; n < vec1.size(); n++) {
			mag1 += Math.pow(vec1.get(n), 2);
			mag2 += Math.pow(vec2.get(n), 2);
		}

		mag1 = Math.sqrt(mag1);
		mag2 = Math.sqrt(mag2);

		double csim = dop / (mag1 * mag2);
		return csim;
	}

	
	@Override
	public void saveData(String usrId, String bookName, String score) {
		iDao.saveData(usrId, bookName, score);
	}

	@Override
	public Map<String, String> loadData(String usrId) {
		return iDao.loadData(usrId);
	}

	@Override
	public void saveUsr(String usrId) {
		iDao.saveUsr(usrId);
	}

	@Override
	public List<String> getUsrList() {
		return iDao.getUsrList();
	}

	@Override
	public List<List<String>> allUsrScoreList() {
		List<List<String>> allUsrScoreList = new ArrayList<List<String>>();
		Map<String, String> usrScore;
		List<String> usrList = getUsrList();

		for (int i = 0; i < usrList.size(); i++) {
			List<String> usrScoreList = new ArrayList<String>();

			usrScore = loadData(usrList.get(i));
			usrScoreList.add(usrList.get(i));
			for(String key : usrScore.keySet()) {
				String value = usrScore.get(key);
				usrScoreList.add(key + " : " + value);
			}
			allUsrScoreList.add(usrScoreList);
		}
		return allUsrScoreList;
	}
	
	@Override
	public String[][] usrBasedSimilarity() {
		Map<String, String> usrScore1;
		Map<String, String> usrScore2;
		
		List<String> usrList = getUsrList();
		String[][] similarityTable = new String[usrList.size()][usrList.size()];
		for(int i=0; i<usrList.size(); i++) {
			for(int j=i+1; j<usrList.size(); j++) {
				List<Double> vec1 = new ArrayList<Double>();
				List<Double> vec2 = new ArrayList<Double>();
				usrScore1 = loadData(usrList.get(i));
				usrScore2 = loadData(usrList.get(j));
				for(String key : usrScore1.keySet()) {
					if(usrScore2.containsKey(key)) {
						vec1.add(Double.parseDouble(usrScore1.get(key)));
						vec2.add(Double.parseDouble(usrScore2.get(key)));
					}
				}
				similarityTable[i][j] = String.format("%.2f", similarity(vec1, vec2));
				similarityTable[j][i] = similarityTable[i][j];
			}
		}
		return similarityTable;
	}
	
	@Override
	public double[][] itemBasedSimilarity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void saveUsrBased(String[][] similarityTable, List<String> usrList) {
		iDao.saveUsrBased(similarityTable, usrList);
	}
}
