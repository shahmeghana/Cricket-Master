package com.nouhoun.springboot.jwt.integration.util;

import java.util.HashMap;
import java.util.Map;

public class Output {
	
	private String responseCode;
	private String message;
	private Map<String, Object> data = new HashMap<>();
	
	public Output() {
		this.responseCode = ResponseCode.ERROR;
		this.message = "Something went wrong";
	}
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		if(responseCode.equals(ResponseCode.OK))
			this.message = "OK";
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}
	
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	//add method
	public void setData(String key, Object value) {
		this.data.put(key, value);
	}
	@Override
	public String toString() {
		return "Output [responseCode=" + responseCode + ", message=" + message + ", data=" + data + "]";
	}	
}
