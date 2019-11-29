package com.yugao.lianzheng.modules.sys.model;

import lombok.Data;

@Data
public class ReportCode {
    public final static ReportCode WAIT_PUBLISH = new ReportCode(0,"未发布");
    public final static ReportCode HAVETO_PUBLISH = new ReportCode(1,"已发布");
    public final static ReportCode HAVETO_DELETE = new ReportCode(2,"已删除");

    private int code;
    private String message;
    ReportCode(int code,String message){
        this.code = code;
        this.message = message;
    }
}
