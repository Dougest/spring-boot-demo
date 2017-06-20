package com.hola.design.decorator;

/**
 * 抽象组件
 * 超类 饮料
 * @author Dougest
 * 2017年5月25日   下午12:46:32
 *
 */
public abstract class Beverage {
	
	public String description = "unknown Beverage";

	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}
