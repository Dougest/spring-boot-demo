package com.hola.design.observer;

public class CurrentConditionsDisplay implements Observer,DisplayElement{
	private Long temp;
	private Long humidity;
	private Subject weatherData;
	    
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }    
	@Override
	public void display() {
		System.out.println("temperature: "+temp+"   humidity: "+humidity);
		
	}

	@Override
	public void update(Long temp, Long humidity, Long pressure) {
		this.temp = temp;
        this.humidity = humidity;
        display();
	}

}
