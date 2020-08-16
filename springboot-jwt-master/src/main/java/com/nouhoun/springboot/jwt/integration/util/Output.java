package com.nouhoun.springboot.jwt.integration.util;

import java.util.HashMap;
import java.util.Map;

public class Output {
	
	private String responseCode;
	private String message;
	private Map<String, Object> results = new HashMap<>();
	
	public Output() {
		this.responseCode = ResponseCode.ERROR.getCode();
		this.message = "Something went wrong";
	}
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getResults() {
		return results;
	}
	
	public void setResults(Map<String, Object> results) {
		this.results = results;
	}
	
	//add method
	public void setResults(String key, Object value) {
		this.results.put(key, value);
	}
	@Override
	public String toString() {
		return "Output [responseCode=" + responseCode + ", message=" + message + ", data=" + results + "]";
	}	
	
	public enum ResponseCode
	{
		ERROR("0000"),
		SUCCESS("0101");
		
		String code;
		ResponseCode(String code)
		{
			this.code = code;
		}
		
		public String getCode()
		{
			return this.code;
		}
	}
}
