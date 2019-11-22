package com.yugao.lianzheng.modules.sys.controller;

import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceTypeEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 记事本管理器
 */
@RestController
@RequestMapping("/referenceType")
@Slf4j
public class LianzhengReferenceTypeController extends AbstractController{

    @Autowired(required = false)
    private LianzhengReferenceTypeService lzReferenceTypeService;

    @RequestMapping(method = RequestMethod.GET, path = "/findList")
    @ResponseBody
    public R queryList() throws Exception {
        LianzhengUserEntity user=getUser();

        List<LianzhengReferenceTypeEntity> list=this.lzReferenceTypeService.getLianzhengReferenceTypeList();
        return R.ok().put("page",list);
    }
}
