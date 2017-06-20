package com.hola.design.decorator;

/**
 * 装饰者
 * 搅拌
 * @author Dougest
 * 2017年5月26日   上午9:40:21
 *
 */
public class Whip extends CondimentDecorator{
	public Beverage beverage;
	public Whip (Beverage beverage){
		this.beverage = beverage;
	}
	public double cost() {
		return .001 + beverage.cost();
	}
	public String getDescription() {
		return   beverage.getDescription()+" , Whip ..";
	}
	
	
}
