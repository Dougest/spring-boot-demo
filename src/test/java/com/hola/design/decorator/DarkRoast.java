package com.hola.design.decorator;

/**
 * 具体组件
 * 深度烘焙咖啡 原料
 * @author Dougest
 * 2017年5月25日   下午12:59:47
 *
 */
public class DarkRoast extends Beverage{
	
	public DarkRoast () {
		description = "DarkRoast";
	}

	public double cost() {
		
		return .1;
	}
}
