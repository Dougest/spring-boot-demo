package com.hola.java8.newfeature;

public interface Duck {
	
	Integer num = 0;
	
	default void shout() {
		System.out.println("嘎嘎嘎...");
	}
	
	default Integer eat() {
		return Duck.num;
	}
	
	static String shout(Integer num) {
		return "adios"+num;
	}
	
	static Integer run(Integer num) {
		return ++num;
	}
	
	class Shout {
		public Shout(String shout) {
			System.out.println(shout);
		}
		
		
	}
}
