package com.example.demo.exception;

public class RecordNOtFoundException extends Exception{

    public RecordNOtFoundException(Integer user_id) {
        super("Can not find user with id = " + user_id.toString());
    }

}
