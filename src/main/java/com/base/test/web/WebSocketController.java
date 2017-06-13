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
@RequestMapping("/websocket")
public class WebSocketController {

	@RequestMapping("/")
	public String index() {
		return "test/websocket";
	}
}
