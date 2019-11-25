package com.yugao.lianzheng.modules.sys.controller;

import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceFileTypeEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceFileTypeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 资料文件类型
 */
@RestController
@RequestMapping("/referenceFileType")
@Slf4j
public class LianzhengReferenceFileTypeController extends AbstractController{

    @Autowired(required = false)
    private LianzhengReferenceFileTypeService lzReferenceFileTypeService;

    @RequestMapping(method = RequestMethod.GET, path = "/findList")
    @ResponseBody
    public R queryList(@Param("referenceTypeId")String referenceTypeId) throws Exception {
        LianzhengUserEntity user=getUser();

        List<LianzhengReferenceFileTypeEntity> list=this.lzReferenceFileTypeService.getLianzhengReferenceFileTypeList(referenceTypeId);
        return R.ok().put("page",list);
    }
}
