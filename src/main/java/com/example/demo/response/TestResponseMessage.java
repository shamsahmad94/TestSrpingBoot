package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResponseMessage {


    public TestResponseMessage(){

    }

    public TestResponseMessage(String status, List<?> results, long count, String message) {
        this.status = status;
        this.results = results;
        this.count = count;
        this.message = message;
    }

    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<?> results;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long count;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

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

    public long getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
