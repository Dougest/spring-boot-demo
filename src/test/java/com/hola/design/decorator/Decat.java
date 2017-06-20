package com.hola.design.decorator;

/**
 * 具体组件
 * 低咖啡因
 * @author Dougest
 * 2017年5月25日   下午12:59:11
 *
 */
public class Decat extends Beverage{
	
	public Decat () {
		description = "Decat";
	}
	@Override
	public double cost() {
		return 1.05;
	}

}
