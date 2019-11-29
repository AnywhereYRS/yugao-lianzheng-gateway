package com.yugao.lianzheng.modules.sys.model;

import lombok.Data;

@Data
public class NewsCode {
    public final static NewsCode WAIT_PUBLISH = new NewsCode(0,"未发布");
    public final static NewsCode HAVETO_PUBLISH = new NewsCode(1,"已发布");
    public final static NewsCode HAVETO_DELETE = new NewsCode(-1,"已删除");

    private int code;
    private String message;
    NewsCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
