/**
 * 
 */
package com.base.test.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.base.user.domain.UserInfo;

/**
 * @author Think
 *
 */
@Service
public class CacheService {

	private static int flag = 10000;

	@CachePut(value = "userCache", key = "#result.username")
	public UserInfo save(UserInfo userInfo) {
		userInfo.setId(11234);
		return userInfo;
	}

	@Cacheable(value = "usernnCache1", key = "#username")
	public UserInfo get(String username) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username + flag);
		userInfo.setId(flag++);
		userInfo.setEmail("123123");
		return userInfo;
	}
}
