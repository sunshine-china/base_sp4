/**
 * 
 */
package com.base.test.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ȫ���쳣����
 * 
 * @author Think
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String globalException() {
		return "error/500";
	}
}
