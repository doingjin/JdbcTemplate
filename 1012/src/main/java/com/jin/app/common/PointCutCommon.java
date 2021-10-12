package com.jin.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutCommon {
	// <포인트컷 모음>
	// 참조 메서드
	// 어드바이스가 포인트컷을 "식별"하기위해 작성
	// 로직은 작성할필요 X {}바디블럭이 비어있음
	
	@Pointcut("execution(* model..*Impl.get*(..))")
	public void get() {}
	// get메서드
	
	/* @Pointcut("execution(* model.client.*Impl.login(..))")
	public void login() {}
	// login메서드 */
	
	@Pointcut("execution(* model..*Impl.*(..))")
	public void all() {}
	// all메서드
}
