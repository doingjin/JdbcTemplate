package com.jin.app.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class Advice {
	
	@Before("PointCutCommon.get()")
	public void printLog(JoinPoint jp) {
		//Object[] args=jp.getArgs();
		//System.out.println(args[0]);
		
		String ms=jp.getSignature().getName();
		System.out.println("👊 '"+ms+"' : PRINTING DATA.......");
		// 응집도가 높다!
	}
	
	@Around("PointCutCommon.all()")
	public Object excep(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw=new StopWatch();
		sw.start();
		Object obj=pjp.proceed();
		sw.stop();
		System.out.println("수행메서드: "+pjp.getSignature().getName());
		System.out.println("===> 수행속도: "+sw.getTotalTimeSeconds()+"초");
		return obj;
	}
	
}
