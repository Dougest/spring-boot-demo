package com.hola.design.factory.simple;

import com.hola.design.factory.Pizza;

public class Online {
	public static void main(String[] args) {
		PizzaStore p = new PizzaStore();
		Pizza p1 = p.orderPizza("cheese");
		//System.out.println(p1);
		
		
	}
}
