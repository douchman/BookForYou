package com.proj.bookforyou.Recommend.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class RecommencServiceImpl implements IRecommendService{
	@Override
	public void saveData(String usrId, String bookName, String score) {
		JedisPubSubClient jedisPubSub = new JedisPubSubClient("127.0.0.1", 6379, "1234");
		Jedis jedis = jedisPubSub.getResource();
		
		Map<String, String> bookScore = new HashMap<String, String>();
		bookScore.put(bookName, score);
		jedis.hmset(usrId, bookScore);
		
		jedis.close();
		jedisPubSub.close();
	}
	@Override
	public Map<String, String> loadData(String usrId) {
		JedisPubSubClient jedisPubSub = new JedisPubSubClient("127.0.0.1", 6379, "1234");
		Jedis jedis = jedisPubSub.getResource();
		
		Map<String, String> usrScore = jedis.hgetAll(usrId);
		jedis.close();
		jedisPubSub.close();
		
		return usrScore;
	}
}
