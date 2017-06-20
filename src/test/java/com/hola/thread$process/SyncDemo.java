package com.hola.thread$process;

public class SyncDemo extends Thread{
	
	private static Object lock = new Object();
	
	public  void run(){
		synchronized(lock){
			for(int i = 0; i<5 ; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}
		}
		
	}
	public static void main(String[] args) {
		SyncDemo s = new SyncDemo();
		s.setName("new Thread-A");
		s.start();
		
		SyncDemo s1 = new SyncDemo();
		s1.setName("new Thread-B");
		s1.start();
	}
}
