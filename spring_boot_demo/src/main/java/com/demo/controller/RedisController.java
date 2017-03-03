package com.demo.controller;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/** 
* @ClassName: RedisController 
* @Description: 测试Redis用例
* @author xuechen
* @date 2017年3月3日 下午5:24:14
*  
*/
@Controller
public class RedisController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private JedisPool jedisPool;
	
	/**
	 * 通过StringRedisTemplate实现对String对象的存、取操作
	 * @return
	 */
	@RequestMapping("/redis/test")
	public @ResponseBody String test() {
		//保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
		
		return stringRedisTemplate.opsForValue().get("aaa");
	}
	
	/**
	 * 通过传统redis连接池获取redis连接
	 * @param key
	 * @return
	 */
	@RequestMapping("/redis/get")
	public @ResponseBody String get(String key) {
		Jedis jedis = jedisPool.getResource();
		return jedis.get(key);
	}
}
