package com.qfedu.controller;

import java.util.Iterator;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qfedu.vo.JsonBean;

@ControllerAdvice
@ResponseBody

//@RestControllerAdvice // 相当于@ControllerAdvice和@ResponseBody
public class CommonException {

	@ExceptionHandler(ConstraintViolationException.class)
	public JsonBean constraintViolation(ConstraintViolationException ex){
		
		// 获取ConstraintViolationException异常中的信息
		Iterator<javax.validation.ConstraintViolation<?>> iterator = 
				ex.getConstraintViolations().iterator();
		String errorInfo = "";
		while(iterator.hasNext()){
			javax.validation.ConstraintViolation<?> next = iterator.next();
			// 打印具体的异常信息
			//System.out.println(next.getMessage());
			errorInfo += next.getMessage() + ",";
		}
		return new JsonBean(0, errorInfo);
		
	}
	
	@ExceptionHandler(Exception.class)
	public JsonBean commonException(Exception e){
		System.out.println(e.getMessage());
		
		return new JsonBean(0, e.getMessage());
	}
}
