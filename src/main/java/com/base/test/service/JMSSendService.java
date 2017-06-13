/**
 * 
 */
package com.base.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

import com.base.test.domain.DemoBean;

/**
 * @author Think
 *
 */
@Service
public class JMSSendService {

	@Autowired
	private JmsOperations jmsOperations;

	public void sendMsgDemoBean(DemoBean demoBean) {
		// jmsOperations.send("base.test.queue", new MessageCreator() {
		//
		// @Override
		// public Message createMessage(Session session) throws JMSException {
		//
		// return session.createObjectMessage(demoBean);
		// }
		// });
		jmsOperations.convertAndSend(demoBean);
		demoBean.setName("base.a.queue");
		jmsOperations.convertAndSend("base.a.queue", demoBean);
	}
}
