package com.yugao.lianzheng.modules.sys.controller;

import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录
 */
@RestController
@RequestMapping("/sso")
@Slf4j
public class SsoController extends AbstractController{

    private List<User> user = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    @ResponseBody
    public R deleteLianzhengReport(@Param("code") String code) throws Exception {

        return R.ok();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/userinfo")
    @ResponseBody
    public R publishLianzhengReport() throws Exception {

        return R.ok().put("user",user);
    }
}
