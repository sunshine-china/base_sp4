/**
 * 
 */
package com.base.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Think
 *
 */
@Controller
public class RootContoller {

	@RequestMapping("/test")
	public String test() {
		return "test";
	}
}
