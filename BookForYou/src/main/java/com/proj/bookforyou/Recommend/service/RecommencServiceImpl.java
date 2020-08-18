package com.proj.bookforyou.Recommend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Tuple;

@Service
public class RecommencServiceImpl implements IRecommendService {
	@Autowired
	private IRedis iRedis;

	
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
	public void saveData(String usrId, String bookName, double score) {
		iRedis.saveData(usrId, bookName, score);
	}

	@Override
	public Map<String, String> loadData(String usrId) {
		return iRedis.loadData(usrId);
	}

	@Override
	public void saveUsr(String usrId) {
		iRedis.saveUsr(usrId);
	}

	@Override
	public List<String> getUsrList() {
		return iRedis.getUsrList();
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
		for(int i=0; i<usrList.size(); i++) {
			similarityTable[i][i] = "0";
		}
		return similarityTable;
	}
	
	@Override
	public List<List<String>> usrBasedRecommend() {
		List<List<String>> recommendList = new ArrayList<List<String>>();
		List<String> usrList = getUsrList();								//회원 목록 가져오기
		for(int i=0; i<usrList.size(); i++) {								//각각의 회원마다 실행
			List<String> usrRecommendList = new ArrayList<String>();
			Set<Tuple> usrSimilarity = iRedis.getUsrBasedSimilarity(usrList.get(i) + "Similarity");		//유사도가 높은 다른회원 2명 가져오기
			Map<String, String> usrBook = loadData(usrList.get(i));										//추천 받을 회원의 평가한 책 목록
			for(Tuple tuple : usrSimilarity) {													//유사도가 높은 다른회원마다 실행
				Map<String, String> similarUsrBookData = loadData(tuple.getElement());			//유사도가 높은 다른회원의 책 목록 가져오기
				for(String book : similarUsrBookData.keySet()) {								//유사도가 높은 다른회원의 책 목록에서 하나씩
					if(!usrBook.containsKey(book) && !usrRecommendList.contains(book) && Double.parseDouble(similarUsrBookData.get(book)) > 3) {
						//추천 받을 회원이 평가하지 않은 책
						//추천목록에 없는 책
						//평점을 3점 이상 준 책
						usrRecommendList.add(book);												//추천 목록에 추가
					}
				}
			}
			recommendList.add(usrRecommendList);
		}
		return recommendList;
	}
	
	@Override
	public void saveUsrBased(String[][] similarityTable, List<String> usrList) {
		iRedis.saveUsrBased(similarityTable, usrList);
	}
}
