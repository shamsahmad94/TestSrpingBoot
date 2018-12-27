package com.example.demo.response;

public class FailedTestResponseMessage extends TestResponseMessage {
    public FailedTestResponseMessage(String message){
        super("failed",null,0,message);
    }
}
