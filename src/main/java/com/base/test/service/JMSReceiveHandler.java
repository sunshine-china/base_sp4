/**
 * 
 */
package com.base.test.service;

import org.springframework.stereotype.Component;

import com.base.test.domain.DemoBean;

/**
 * @author Think
 *
 */
@Component("jmsReceiveHandler")
public class JMSReceiveHandler {

	public void handlerMsg(DemoBean demoBean) {
		System.out.println("DemoBean:" + demoBean);
	}

	public void handderMsga(DemoBean demoBean) {
		System.out.println("handderMsga:" + demoBean);
	}
}
