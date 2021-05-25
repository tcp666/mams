package com.mams.mamscommon.utils;

import java.io.Serializable;

/**
 *@ClassName Result
 *@Description TODO
 *@Author  TangCaiping
 *@Date 2021/3/2 12:53
 *@Version 1.0
 */
public class Result<T> implements Serializable {
	private T value;
	private boolean success;
	private String message;
	private String status;
	public static final Result result=new Result();
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	
	public static Result success(Object t){
		result.value=t;
		result.message="success";
		result.status="10000";
		result.success=true;
		return result;
	}
	 public static Result fail(Object t){
		 result.value=t;
		 result.message="fail";
		 result.status="10001";
		 return result;
	 }
}
