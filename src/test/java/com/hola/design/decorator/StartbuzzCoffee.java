package com.hola.design.decorator;

import com.hola.design.decorator.DarkRoast;
import com.hola.design.decorator.Espresso;
import com.hola.design.decorator.Mocha;
import com.hola.design.decorator.Whip;


/**
 * 某巴克咖啡厅
 * @author Dougest
 * 2017年5月26日   上午9:41:08
 *
 */
public class StartbuzzCoffee {
	public static void main(String[] args) {
		//Beverage beverage = new Espresso();
		
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription()+" $"+beverage2.cost());
	}
}
