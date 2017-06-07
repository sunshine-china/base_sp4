/**
 * 
 */
package com.base.test.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * È«¾ÖÒì³£À¹½Ø
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
