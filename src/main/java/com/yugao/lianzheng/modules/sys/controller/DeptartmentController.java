package com.yugao.lianzheng.modules.sys.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org")
@Slf4j
public class DeptartmentController  extends AbstractController{

    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    @ResponseBody
    public R query() {
        LianzhengUserEntity user=getUser();
        String data = departmentService.getOrgList();
        JSONObject page = (JSONObject)JSONObject.parseObject(data).get("page");
        JSONArray list = (JSONArray)page.get("list");
        return R.ok().put("data",list);
    }
}
