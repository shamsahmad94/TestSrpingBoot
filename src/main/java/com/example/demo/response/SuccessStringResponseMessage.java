package com.example.demo.response;

import java.util.List;


public class SuccessStringResponseMessage extends StringResponseMessage{

	
	 public SuccessStringResponseMessage(String message,String Message){
			super("success",null,message);
		}
}
