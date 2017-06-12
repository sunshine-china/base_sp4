/**
 * 
 */
package com.base.test.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.base.test.service.SecurityService;
import com.base.user.domain.UserInfo;

/**
 * @author Think
 *
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

	@Autowired
	public SecurityService securityService;

	@Secured({ "ROLE_ADMIN", "ROLE_TEST" })
	@RequestMapping("/secured")
	public String testSecured() {
		return "test secured success";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or (hasRole('ROLE_USER') and #id>1000)")
	@RequestMapping("/pre")
	public String testPretAutho(int id) {
		return "test pre success";
	}

	@RequestMapping("/post")
	public String testPostAuth(String name) {
		securityService.getUserInfo(name);
		return "success";
	}

	@RequestMapping("/list")
	public @ResponseBody List<UserInfo> getUserInfos() {
		return securityService.getUserInfos();
	}
}
