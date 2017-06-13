/**
 * 
 */
package com.base.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.test.domain.DemoBean;
import com.base.test.service.AmqpService;

/**
 * @author Think
 *
 */
@RestController
@RequestMapping("/amqp")
public class AmqpController {

	@Autowired
	private AmqpService amqpService;

	@RequestMapping("/testa")
	public String testa() {
		DemoBean bean = new DemoBean();
		bean.setId(1);
		bean.setName("test amqp");
		bean.setPrice(66.33);
		amqpService.sendMsg(bean);
		return "success";
	}
}
