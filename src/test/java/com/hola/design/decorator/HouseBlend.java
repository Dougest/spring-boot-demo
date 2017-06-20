package com.hola.design.decorator;

/**
 * 具体组件
 * 综合咖啡
 * @author Dougest
 * 2017年5月25日   下午12:56:16
 *
 */
public class HouseBlend extends Beverage{
	public  HouseBlend() {
		description = "HouseBlend";
	}
	
	public double cost() {
		
		return .89;
	}

}
