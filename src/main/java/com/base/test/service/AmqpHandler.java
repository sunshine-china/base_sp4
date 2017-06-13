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
@Component
public class AmqpHandler {

	public void handlerAmpq(DemoBean demoBean) {
		System.out.println("handlerAmpq:" + demoBean);
	}
}
