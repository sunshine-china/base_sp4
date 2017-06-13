/**
 * 
 */
package com.base.test.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.test.domain.DemoBean;

/**
 * @author Think
 *
 */
@Service
public class AmqpService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(DemoBean demoBean) {
		rabbitTemplate.convertAndSend(demoBean);
		System.out.println("send one end");
		demoBean.setName("base.amqp.test.queue2");
		rabbitTemplate.convertAndSend("base.test.exchange", "base.amqp.test.queue2", demoBean);
		System.out.println("send two end");
	}
}
