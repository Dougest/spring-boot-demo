package com.hola.design.decorator;

/**
 * 装饰者
 * 摩卡 调料
 * @author Dougest
 * 2017年5月26日   上午9:38:49
 */
public class Mocha extends CondimentDecorator{
	
	public Beverage beverage;
	/**
	 * 把饮料当做构造器的参数,再由构造器将此饮料记录在实例变量中
	 * @param beverage
	 */
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	/**
	 * 利用委托的做法,得到一个叙述,然后在其后面加上一个附加的叙述
	 */

	public double cost() {
		return .01 + beverage.cost();
	}
	
	public String getDescription() {
		 return beverage.getDescription()+ " , Mocha  ";
	}

}
