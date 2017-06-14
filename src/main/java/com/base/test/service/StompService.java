/**
 * 
 */
package com.base.test.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.base.test.domain.DemoBean;
import com.base.test.domain.Shout;

/**
 * @author Think
 *
 */
@Service
public class StompService {

	private Logger logger = LogManager.getLogger(StompService.class);

	@Autowired
	private SimpMessagingTemplate messaging;
	private Pattern pattern = Pattern.compile("\\@(\\S+)");

	public void broadcastSpittle(DemoBean demo) {
		messaging.convertAndSend("/topic/spittlefeed", demo);

		Matcher matcher = pattern.matcher(demo.getName());
		if (matcher.find()) {
			String username = matcher.group(1);
			logger.info("matcher.group(1) -->" + username);
			messaging.convertAndSendToUser(username, "/queue/notifications", new Shout("You just got mentioned!"));
		}
	}
}
