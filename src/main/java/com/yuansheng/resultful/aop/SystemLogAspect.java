package com.yuansheng.resultful.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect 
@Component
public class SystemLogAspect {

	Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

	@Before("execution(* com.yuansheng.resultful.controller..*(..))")
	public void beforeInterceptor(JoinPoint joinPoint) {
		// LogUtils.info(logger, "{0} 被调用，请求参数是{1}", joinPoint.getSignature()
		// .getName(), joinPoint.getArgs());
		System.out.println("进入代理");
	}
}
