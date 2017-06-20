package com.hola.design.decorator;

/**
 * 具体组件
 * 浓缩咖啡
 * @author Dougest
 * 2017年5月25日   下午12:52:16
 *
 */
public class Espresso extends Beverage{
	public Espresso () {
		description = "Espresso";
	}
	
	public double cost() {
		return 1.99;
	}

}
