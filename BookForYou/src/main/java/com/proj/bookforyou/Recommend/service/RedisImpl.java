package com.proj.bookforyou.Recommend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

@Service
public class RedisImpl implements IRedis{
	@Override
	public void saveData(String usrId, String bookName, double score) {
		JedisPubSubClient jedisPubSub = new JedisPubSubClient("127.0.0.1", 6379);
		Jedis jedis = jedisPubSub.getResource();
		
		Map<String, String> bookScore = new HashMap<String, String>();
		bookScore.put(bookName, Double.toString(score));
		jedis.hmset(usrId, bookScore);
		jedis.zadd(usrId, score, bookName);
		
		jedis.close();
		jedisPubSub.close();
	}
	@Override
	public Map<String, String> loadData(String usrId) {
		JedisPubSubClient jedisPubSub = new JedisPubSubClient("127.0.0.1", 6379);
		Jedis jedis = jedisPubSub.getResource();
		
		Map<String, String> usrScore = jedis.hgetAll(usrId);
		
		jedis.close();
		jedisPubSub.close();
		
		return usrScore;
	}
	@Override
	public Double getScore(String usrId, String bookName) {
		JedisPubSubClient jedisPubSub = new JedisPubSubClient("127.0.0.1", 6379);
		Jedis jedis = jedisPubSub.getResource();
		
		double score = jedis.zscore(usrId, bookName);
		
		jedis.close();
		jedisPubSub.close();
		
		return score;
	}
	@Override
	public void saveUsr(String usrId) {
		JedisPubSubClient jedisPubSub = new JedisPubSubClient("127.0.0.1", 6379);
		Jedis jedis = jedisPubSub.getResource();
		
		jedis.lpush("usrId", usrId);
		
		jedis.close();
		jedisPubSub.close();
	}
	@Override
	public List<String> getUsrList() {
		JedisPubSubClient jedisPubSub = new JedisPubSubClient("127.0.0.1", 6379);
		Jedis jedis = jedisPubSub.getResource();
		
		List<String> usrList = jedis.lrange("usrId", 0, -1);
		jedis.close();
		jedisPubSub.close();
		
		return usrList;
	}
	@Override
	public void saveUsrBased(String[][] similarityTable, List<String> usrList) {
		JedisPubSubClient jedisPubSub = new JedisPubSubClient("127.0.0.1", 6379);
		Jedis jedis = jedisPubSub.getResource();
		
		for(int i=0; i<usrList.size(); i++) {
			//Map<String, String> usrBasedSimilarity = new HashMap<String, String>();
			String usrSimilarity = usrList.get(i) + "Similarity";
			for(int j=0; j<usrList.size(); j++) {
				//usrBasedSimilarity.put(usrList.get(j), similarityTable[i][j]);
				jedis.zadd(usrSimilarity, Double.parseDouble(similarityTable[i][j]), usrList.get(j));
			}
			//jedis.hmset(usrSimilarity, usrBasedSimilarity);
		}
		jedis.close();
		jedisPubSub.close();
	}
	@Override
	public Set<Tuple> getUsrBasedSimilarity(String usrId) {
		JedisPubSubClient jedisPubSub = new JedisPubSubClient("127.0.0.1", 6379);
		Jedis jedis = jedisPubSub.getResource();
		
		Set<Tuple> usrSimilarity = jedis.zrevrangeWithScores(usrId, 0, 1);
		
		jedis.close();
		jedisPubSub.close();
		
		return usrSimilarity;
	}
}