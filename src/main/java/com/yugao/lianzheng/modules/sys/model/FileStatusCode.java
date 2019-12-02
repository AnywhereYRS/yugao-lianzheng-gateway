package com.yugao.lianzheng.modules.sys.model;

import lombok.Data;

@Data
public class FileStatusCode {
    public final static FileStatusCode WAIT_PUBLISH = new FileStatusCode(0,"未发布");
    public final static FileStatusCode HAVETO_PUBLISH = new FileStatusCode(1,"已发布");
    public final static FileStatusCode HAVETO_DELETE = new FileStatusCode(-1,"已删除");

    private int code;
    private String message;
    FileStatusCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
