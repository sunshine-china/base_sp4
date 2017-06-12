/**
 * 
 */
package com.base.test.domain;

import java.io.Serializable;

/**
 * @author Think
 *
 */
public class DemoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6335069082110538885L;

	private int id;

	private String name;

	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DemoBean [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
	

}
