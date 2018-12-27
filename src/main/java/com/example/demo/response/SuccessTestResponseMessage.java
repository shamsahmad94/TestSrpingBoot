package com.example.demo.response;

import java.util.HashMap;
import java.util.List;

import com.example.demo.models.Task_definition;

public class SuccessTestResponseMessage extends TestResponseMessage {
    public SuccessTestResponseMessage(List<?> userList, long count){
        super("success",userList,count,"");
    }
    
}
