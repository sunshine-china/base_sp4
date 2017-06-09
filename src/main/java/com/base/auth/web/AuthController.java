/**
 * 
 */
package com.base.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Think
 *
 */
@Controller
public class AuthController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/base/login", method = RequestMethod.GET)
	public String blogin() {
		return "login";
	}
}
