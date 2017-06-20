package com.hola.thread$process;

public class ThreadDemo extends Thread{
	private String name;
	
	public ThreadDemo(String name){
		this.name = name;
	}
	
	
	public void run(){
		System.out.println("执行run方法"+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		System.out.println("main"+Thread.currentThread().getName());
		new ThreadDemo("t2").start();
		new ThreadDemo("t1").run();
	}
}	
