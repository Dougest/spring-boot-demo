package com.hola.component;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hola.util.JsonResult;


/**
 * 拦截器  可以进行 记录用户操作日志，检查用户是否登陆 等等等等等
 * @author Dougest 2017年5月7日    下午4:44:07
 *
 */
@Aspect
@Component
public class ControllerInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(ControllerInterceptor.class); 
	
	/*@Value("")
	private String env;*/
	/**
	 * 定义拦截器规则 指定dougest下所有类中，有@RequestMapping注解的方法
	 */
	@Pointcut("execution(* com.hola.controller.test..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void controllerMethodPointcut() {}
	
	/**
	 * 被拦截方法的执行结果，
	 * @param pjp
	 * @return
	 * @throws Throwable 
	 */
	@SuppressWarnings("rawtypes")
	@Around("controllerMethodPointcut()")
	public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable{
		long beginTime = System.currentTimeMillis();
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod(); //获取被拦截的方法
		String methodName = method.getName(); //获取被拦截的方法名
		
		Set<Object> allParams = new LinkedHashSet<>(); //保存所有请求参数，用于输出到日志中
		
		log.info("请求开始，方法：{}", methodName);
		Object result = null;
		Object[] args = pjp.getArgs();
		log.debug("参数 args: {}", args);
		
		/**********************************code*************************************/
		for(Object arg : args){
			
			if (arg instanceof Map<?, ?>) {
				//提取方法中的MAP参数，用于记录进日志中
				@SuppressWarnings("unchecked")
				Map<String, Object> map = (Map<String, Object>) arg;
				System.out.println(map);
				allParams.add(map);
			}else if(arg instanceof HttpServletRequest){
				
				HttpServletRequest request = (HttpServletRequest) arg;
				if(isLoginRequired(method)){   
					if(!isLogin(request)){
						result = new JsonResult();
						((JsonResult) result).setMessage("该操作需要登录！去登录吗？");
						//代码....
					}
				}
				
				//获取query string 或 posted form data参数
				Map<String, String[]> paramMap = request.getParameterMap();
				if(paramMap!=null && paramMap.size()>0){
					allParams.add(paramMap);
				}
				
				
			}else if(arg instanceof HttpServletResponse){
				//do nothing...
				//代码....
			}else{
				//allParams.add(arg);
				//代码....
			}
			
		}
		/***********************************code***************************************/
		try {
			if(result == null){
				// 一切正常的情况下，继续执行被拦截的方法
				result = pjp.proceed();
			}
		} catch (Throwable e) {
			log.info("exception: ", e);
			((JsonResult) result).setMessage("发生异常："+e.getMessage());
		}
		
			long costMs = System.currentTimeMillis() - beginTime;
			log.info("方法 {} 请求结束，耗时：{}ms", methodName, costMs);
		
			Object returnArgs = pjp.proceed();	
			log.info("返回值:  {} ",returnArgs);
			
			
		return result;
	}
	

	
	
	

	/**
	 * 假装我判断了 是否必须登陆
	 * @param method
	 * @return
	 */
	private boolean isLoginRequired(Method method){
		/*if(!env.equals("prod")){ //只有生产环境才需要登录
			return false;
		}*/
		//代码....
	
		return true;
	}
	/**
	 * 判断是否已经登录
	 * 假装判断了
	 * @param request
	 * @return
	 */
	private boolean isLogin(HttpServletRequest request) {
		//代码....
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
