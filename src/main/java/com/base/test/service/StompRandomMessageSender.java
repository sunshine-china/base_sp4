/**
 * 
 */
package com.base.test.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.base.test.domain.Shout;

/**
 * @author Think
 *
 */
@Component
public class StompRandomMessageSender {

	Logger logger = LogManager.getLogger(StompRandomMessageSender.class);

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@Scheduled(fixedRate = 10000)
	public void sendRandomNumber() {
		Shout shout = new Shout();
		shout.setMessage("Random #" + (Math.random() * 100));
		logger.info("scheduled send:" + shout.getMessage());
		messagingTemplate.convertAndSend("/topic/marco", shout);
	}

}
