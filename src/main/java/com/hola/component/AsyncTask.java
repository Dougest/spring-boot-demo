/*package com.hola.component;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

*//**
 * 	并发编程
 * 
 *  线程是属于异步计算模型，所以你不可能直接从别的线程中得到函数返回值。 
 *	这时候，Future就出场了。Futrue可以监视目标线程调用call的情况，
 *	当你调用Future的get()方法以获得结果时，当前线程就开始阻塞，直接call方法结束返回结果。 
 *
 * @author Dougest 2017年5月2日    下午10:42:20
 *
 *//*
@Component
public class AsyncTask {
protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Async("mySimpleAsync")
	public Future<String> doTask1() throws InterruptedException{
		logger.info("Task1 started.");
		long start = System.currentTimeMillis();
        Thread.sleep(5000);
        long end = System.currentTimeMillis();
        
        logger.info("Task1 finished, time elapsed: {} ms.", end-start);
        
        return new AsyncResult<>("Task1 accomplished!");
	}
	
	@Async("myAsync")
	public Future<String> doTask2() throws InterruptedException{
		logger.info("Task2 started.");
		long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        
        logger.info("Task2 finished, time elapsed: {} ms.", end-start);
        
        return new AsyncResult<>("Task2 accomplished!");
	}

}
*/