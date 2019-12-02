package com.yugao.lianzheng.modules.sys.model;

import lombok.Data;

@Data
public class ModuleCode {
    public final static ModuleCode LIANZHENG_NEWS = new ModuleCode(1,"廉政动态附件");
    public final static ModuleCode LIANZHENG_IMG = new ModuleCode(2,"廉政图片附件");
    public final static ModuleCode LIANZHENG_MEANS = new ModuleCode(3,"廉政资料");
    public final static ModuleCode LIANZHENG_REPOTR = new ModuleCode(4,"廉政报告");
    public final static ModuleCode MEANS_MODULE = new ModuleCode(5,"资料模板");

    private int code;
    private String message;
    ModuleCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
