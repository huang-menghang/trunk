package com.yuansheng.resultful.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yuansheng.resultful.util.HttpUtils;

@Aspect
@Component
public class SystemLogAspect {

	Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

	@Before("execution(* com.yuansheng.resultful.controller..*(..))")
	public void beforeInterceptor(JoinPoint joinPoint) throws Exception {
		// LogUtils.info(logger, "{0} 被调用，请求参数是{1}", joinPoint.getSignature()
		// .getName(), joinPoint.getArgs());
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String ip = HttpUtils.getIp(request);
		System.out.println("请求方法:"
				+ (joinPoint.getTarget().getClass().getName() + "."
						+ joinPoint.getSignature().getName() + "()"));
		System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
	    System.out.println("ip:"+ip);
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getControllerMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		return targetName + "  " + methodName;
	}
}
