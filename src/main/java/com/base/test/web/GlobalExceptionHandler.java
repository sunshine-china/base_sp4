/**
 * 
 */
package com.base.test.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常类
 * 
 * @author Think
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String globalException(Exception e) {
		e.printStackTrace();
		return "error/500";
	}
}
