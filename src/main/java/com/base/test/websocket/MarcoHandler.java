/**
 * 
 */
package com.base.test.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * @author Think
 *
 */

public class MarcoHandler extends AbstractWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("Received message:" + message.getPayload());
		Thread.sleep(5000);
		session.sendMessage(new TextMessage("I got " + message.getPayload()));
	}
}
