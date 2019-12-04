package com.yugao.lianzheng.modules.sys.model;

import lombok.Data;

@Data
public class UserStatusCode {
    public final static UserStatusCode DISABLE_USER = new UserStatusCode(0,"禁用");
    public final static UserStatusCode NORMAL_USER = new UserStatusCode(1,"正常");

    private int code;
    private String message;
    UserStatusCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
