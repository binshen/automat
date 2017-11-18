package com.unipresident.automat.model;

import java.util.Map;

public class Response {

    private int result;

    private String message;

    private Map[] data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map[] getData() {
        return data;
    }

    public void setData(Map[] data) {
        this.data = data;
    }
}
