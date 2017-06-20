package com.hola.design.factory.simple;

import com.hola.design.factory.Pizza;

/**
 * 消费者
 * @author Dougest
 * 2017年6月5日   上午8:44:50
 *
 */
public class PizzaStore {
	SimpleFactory facotry;
	
	public Pizza orderPizza(String type){
		facotry = new CommonFactory();
		Pizza p = facotry.createPizza(type);
		p.prepare();
		p.bake();
		p.cut();
		p.box();
		return p;
	}
	
}
