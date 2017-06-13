/**
 * 
 */
package com.base.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.test.domain.DemoBean;
import com.base.test.service.JMSSendService;

/**
 * @author Think
 *
 */
@RestController
@RequestMapping("/jms")
public class JMSController {

	@Autowired
	private JMSSendService jmsSendService;

	@RequestMapping("/testa")
	public String testa() {
		DemoBean demoBean = new DemoBean();
		demoBean.setId(1);
		demoBean.setName("666hao看得");
		demoBean.setPrice(123.33);
		jmsSendService.sendMsgDemoBean(demoBean);
		return "success";
	}
}
