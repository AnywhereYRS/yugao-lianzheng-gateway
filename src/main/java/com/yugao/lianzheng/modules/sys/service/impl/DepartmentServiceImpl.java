package com.yugao.lianzheng.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yugao.lianzheng.common.utils.HttpUtils;
import com.yugao.lianzheng.modules.sys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Value("${yugao.hr.api.url}")
    private String url;

    @Value("${yugao.hr.api.orglist}")
    private String orglistApi;

    /**
     * 获取组织架构列表
     * **/
    @Override
    public String getOrgList(){
        Map<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("limit","500");
        String data =  HttpUtils.doPost(url+orglistApi,map);
        return data;
    }
}
