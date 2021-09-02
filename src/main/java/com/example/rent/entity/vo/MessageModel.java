package com.example.rent.entity.vo;

/**
 * 消息模型对象
 * 状态码 1：成功，0：失败
 * 回显数据：object对象
 */
public class MessageModel {
    private Integer code= 1;//状态码
    private String  message = "成功!";
    private Object object;//回显对象

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
