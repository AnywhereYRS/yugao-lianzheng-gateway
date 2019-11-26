package com.yugao.lianzheng.modules.sys.controller;

import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengContactEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 首页-廉政信箱
 */
@RestController
@RequestMapping("/contact")
@Slf4j
public class LianzhengContactController extends AbstractController{

    @Autowired(required = false)
    private LianzhengContactService lzContactService;

    @RequestMapping(method = RequestMethod.GET, path = "/find")
    @ResponseBody
    public R query() {
        LianzhengUserEntity user=getUser();
        LianzhengContactEntity entity=this.lzContactService.getLianzhengContactDetail();
        return R.ok().put("data",entity);
    }
}
