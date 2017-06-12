/**
 * 
 */
package com.base.test.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

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

	/**
	 * 响应的Accept头信息：application/json
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserInfo userInfo(@RequestParam String username) {
		return userMapper.getUserInfoByName(username);
	}

	/**
	 * 请求头的content-Type:application/json
	 * 
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = "application/json")
	public String saveUser(@RequestBody UserInfo userInfo) {
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserInfo> findOneById(@PathVariable int id) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(id);

		HttpStatus status = userInfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<UserInfo>(userInfo, status);
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public UserInfo findUserById(@PathVariable int id) throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(id);

		if (null == userInfo) {
			throw new Exception("userinfo notfound");
		}

		return userInfo;
	}

	public ResponseEntity<UserInfo> findUserByIdUserEntity(@PathVariable int id,
			UriComponentsBuilder uriComponentsBuilder) {
		UserInfo userInfo = new UserInfo();

		HttpHeaders headers = new HttpHeaders();
		URI locationUri = uriComponentsBuilder.path("/base/").path(String.valueOf(userInfo.getId())).build().toUri();
		headers.setLocation(locationUri);

		ResponseEntity<UserInfo> responseEntity = new ResponseEntity<UserInfo>(userInfo, headers, HttpStatus.CREATED);
		return responseEntity;
	}

}
