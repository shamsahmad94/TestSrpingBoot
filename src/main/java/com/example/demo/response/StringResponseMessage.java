package com.example.demo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StringResponseMessage {

	
	public StringResponseMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StringResponseMessage(String status, List<?> results,String message) {
		super();
		this.status = status;
		this.results = results;
		this.message = message;
	}
	private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<?> results;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String message;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<?> getResults() {
		return results;
	}
	public void setResults(List<?> results) {
		this.results = results;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
