package com.hola.thread$process;

public class RunnableDemo implements Runnable{

	@Override
	public void run() {
		
	}
	public static void main(String[] args) {
		//main方法可以认为是一个进程,也可以认为是一个线程
		new Thread(new RunnableDemo()).start();
	}
}
