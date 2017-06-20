package com.hola.design.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品
 * @author Dougest
 * 2017年6月5日   上午8:35:14
 *
 */
public abstract class Pizza {
	String name;
	String dough;
	String sauce;
	List topping = new ArrayList();
	
	public void prepare(){
		System.out.println("Preparing => "+name);
		System.out.println("Tossing dough => > >");
		System.out.println("Adding sauce => > >");
		System.out.println("Add toppings : ");
		for(int i = 0; i< topping.size() ; i++) {
			System.out.println(" "+topping.get(i) +" ");
		}
	}
	
	public void bake() {
		System.out.println("bake for 25 minutes at 350");
	}
	
	public void cut() {
		System.out.println("cutting the pizza into diagonal slics");
	}
	
	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDough() {
		return dough;
	}

	public void setDough(String dough) {
		this.dough = dough;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public List getTopping() {
		return topping;
	}

	public void setTopping(List topping) {
		this.topping = topping;
	}
	
	
	
}
