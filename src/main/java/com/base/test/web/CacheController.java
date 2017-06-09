/**
 * 
 */
package com.base.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Think
 *
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@RequestMapping("/put")
	public String put(String name, String value) {
		redisTemplate.opsForValue().set(name, value);
		return "success";
	}

	@RequestMapping("/get")
	public String get(String name) {
		String result = redisTemplate.opsForValue().get(name);
		return result;
	}

}
