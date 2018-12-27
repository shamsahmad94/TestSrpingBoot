package com.example.demo.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.models.Task_definition;
import com.example.demo.response.FailedTestResponseMessage;
import com.example.demo.response.SuccessStringResponseMessage;
import com.example.demo.response.SuccessTestResponseMessage;

import java.util.HashMap;
import java.util.List;

public class ResponseHelper {

    public static ResponseEntity<SuccessTestResponseMessage> successTest(List<?> userList, long count, HttpStatus httpStatus){
        return new ResponseEntity<>(new SuccessTestResponseMessage(userList,count),httpStatus);
    }
    
    public static ResponseEntity<SuccessStringResponseMessage> successStringMessage(String Message, HttpStatus httpStatus){
        return new ResponseEntity<>(new SuccessStringResponseMessage(Message,null),httpStatus);
    }
    
 
    public static ResponseEntity<FailedTestResponseMessage> failed(String message, HttpStatus httpStatus){
        return new ResponseEntity<>(new FailedTestResponseMessage(message),httpStatus);
    }
}
