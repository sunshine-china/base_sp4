/**
 * 
 */
package com.base.test.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.test.domain.Shout;

/**
 * @author Think
 *
 */
@Controller
public class StompController {

	private static Logger logger = LogManager.getLogger(StompController.class);

	@RequestMapping("/atomp/index")
	public String index() {
		return "test/atomp";
	}

	/**
	 * 隐含前缀/app,返回目的地，默认添加/topic前缀(/topic/marco)，可以重载指定,/topic/shout所有订阅这个主题的应用，都可以收到
	 * 
	 * @param incoming
	 */
	@MessageMapping("/marco")
	// @SendTo("/topic/shout")
	public Shout handlerDemo(Shout incoming) {
		logger.info("Received message:" + incoming.getMessage());
		Shout outgoing = new Shout();
		outgoing.setMessage("Polo!");
		return outgoing;
	}

	/**
	 * 隐含前缀/app,，异步方式。不经过代理直接返回客户端
	 * 
	 * @return
	 */
	// @SubscribeMapping({ "/marco" })
	public Shout handlerSubScription() {
		Shout outgoing = new Shout();
		outgoing.setMessage("I'm is outgoing");
		return outgoing;
	}
}
