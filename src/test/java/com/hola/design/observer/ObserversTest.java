package com.hola.design.observer;

import org.junit.Test;

public class ObserversTest {
	
	
	@Test
    public void test1() {
        WeatherData w = new WeatherData();
        CurrentConditionsDisplay c = new CurrentConditionsDisplay(w);
      //  HeatIndexDisplay h = new HeatIndexDisplay(w);
        w.setChange(1l, 1l, 1l);
        w.setChange(2l, 2l, 2l);
        w.setChange(3l, 3l, 3l);
        
    }
}
