/**
 * 
 */
package com.base.test.domain;

/**
 * @author Think
 *
 */
public class Shout {

	public Shout() {
	}

	public Shout(String message) {
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
