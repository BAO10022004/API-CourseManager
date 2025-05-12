package com.example.QL_KHOAHOC.dtoRespon;

public class ResponClass {
    String message;

    public int getCode() {
        return code;
    }

    public ResponClass(String message, int code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    int code;
    Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
