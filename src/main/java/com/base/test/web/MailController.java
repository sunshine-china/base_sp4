/**
 * 
 */
package com.base.test.web;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Think
 *
 */
@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private JavaMailSender mailSender;

	/**
	 * 发送简单的邮件
	 */
	@RequestMapping("/simple")
	public String sendSimpleSpittleEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("wjj_ly@126.com");
		message.setTo("wuyuxiangcao@163.com");
		message.setSubject("New spittle from wjj_ly@126.com");
		message.setText("Lucy " + " says: " + " Hello Boy !");
		mailSender.send(message);
		return "success";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * spittr.email.SpitterMailService#sendSpittleEmailWithAttachment(java.lang.
	 * String, spittr.domain.Spittle)
	 */
	public void sendSpittleEmailWithAttachment() throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		String spitterName = "Lucy";
		helper.setFrom("noreply@spitter.com");
		helper.setTo("LiLy");
		helper.setSubject("New spittle from " + spitterName);
		helper.setText(spitterName + " says: " + "你好，小年轻！");
		ClassPathResource couponImage = new ClassPathResource("/collateral/coupon.png");
		helper.addAttachment("Coupon.png", couponImage);
		mailSender.send(message);
	}
}
