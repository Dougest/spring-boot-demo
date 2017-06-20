package com.hola.design.factory.simple;

import com.hola.design.factory.Pizza;

public interface SimpleFactory {
	Pizza createPizza(String type);
}
