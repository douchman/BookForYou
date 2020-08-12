package com.proj.bookforyou.Recommend.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPubSubClient {
	private JedisPool pool;

	public JedisPubSubClient(String hostName, int port) {	//JedisPubSubClient("Redis Host Ip", Redis Port)
		super();
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		this.pool = new JedisPool(jedisPoolConfig, hostName, port, 1000);
	}

	/* jedis pool resource return */
	public Jedis getResource() {
		Jedis jedis = this.pool.getResource();
		return jedis;
	}

	/* jedis pool close method */
	public void close(){
        this.pool.close();
    }
}
