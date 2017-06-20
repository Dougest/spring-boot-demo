package com.hola.design.factory.simple;

import com.hola.design.factory.CalmPizza;
import com.hola.design.factory.CheesePiza;
import com.hola.design.factory.DefaultPizza;
import com.hola.design.factory.Pizza;
import com.hola.design.factory.VegglePizza;

public class CommonFactory implements SimpleFactory{

	public Pizza createPizza(String type) {
		switch(type) {
			case "cheese":
				Pizza p1 = new CheesePiza();
				return p1;
			case "clam":
				Pizza p2 = new CalmPizza();
				return p2;
			case "veggle":
				Pizza p3 = new VegglePizza();
				return p3;
			default:
				Pizza p = new DefaultPizza(); 
				return p;
		}
	}

	

}
