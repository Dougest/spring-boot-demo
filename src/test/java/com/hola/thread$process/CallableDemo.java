package com.hola.thread$process;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo implements Callable{

	@Override
	public String call() throws Exception {
		
		return "我是返回值";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Callable<String>c =new CallableDemo();
		Future f = service.submit(c);
		System.out.println(f.get());
	}

}
