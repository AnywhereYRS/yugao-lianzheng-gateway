package com.yugao.lianzheng.common.utils;

import lombok.Data;
/**
 * 分页信息
 * **/
@Data
public class PageBar {
    /**
     * 页码
     * **/
    private int page;
    /**
     * 分页大小
     * **/
    private int size;
    /**
     * 总记录数
     * **/
    private long total;
}
