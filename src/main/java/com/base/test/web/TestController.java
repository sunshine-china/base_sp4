/**
 * 
 */
package com.base.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.user.domain.UserInfo;
import com.base.user.repo.UserMapper;

/**
 * @author Think
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	UserMapper userMapper;

	@RequestMapping("/a")
	public String testa() {
		return "test";
	}

	@RequestMapping("/b")
	public @ResponseBody String testb() {
		return "this is test b";
	}

	@RequestMapping("/user")
	public @ResponseBody UserInfo user(@RequestParam String username) {
		return userMapper.getUserInfoByName(username);
	}
}
