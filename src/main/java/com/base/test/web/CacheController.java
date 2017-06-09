/**
 * 
 */
package com.base.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.test.service.CacheService;
import com.base.user.domain.UserInfo;

/**
 * @author Think
 *
 */
@Controller
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	private CacheService cacheService;

	@RequestMapping("/")
	public String index() {
		return "test/cache";
	}

	@RequestMapping("/save")
	public @ResponseBody UserInfo save(UserInfo userInfo) {
		return cacheService.save(userInfo);
	}

	@RequestMapping("/get")
	public @ResponseBody UserInfo get(String username) {
		return cacheService.get(username);
	}

}
