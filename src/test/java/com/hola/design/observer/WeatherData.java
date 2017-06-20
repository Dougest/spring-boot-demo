package com.hola.design.observer;

import java.util.ArrayList;
/**
 * 数据站
 * @author Dougest
 * 2017年5月26日   上午9:03:26
 *
 */
public class WeatherData implements Subject{
	private ArrayList observers;
	private Long temp;
	private Long humidity;
	private Long pressure;
	
	public WeatherData() {
		observers = new ArrayList();
	}
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0) observers.remove(i);
		else throw new RuntimeException("取消订阅失败");
	}

	public void notifyObservers() {
		for(int i = 0; i< observers.size(); i++) {
			Observer o = (Observer) observers.get(i);
			o.update(temp, humidity, pressure);
		}
	}
	
	public void setChange(Long temp, Long humidity,Long pressure){
		this.humidity = humidity;
		this.temp = temp;
		this.pressure = pressure;
		notifyObservers();
	}

}
