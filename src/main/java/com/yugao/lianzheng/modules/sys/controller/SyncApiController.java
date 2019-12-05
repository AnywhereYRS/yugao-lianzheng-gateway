package com.yugao.lianzheng.modules.sys.controller;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.google.gson.JsonObject;
import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.model.UserStatusCode;
import com.yugao.lianzheng.modules.sys.service.LianzhengUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 登录
 */
@RestController
@RequestMapping("/sync")
@Slf4j
public class SyncApiController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LianzhengUserService lianzhengUserService;

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    public R ssoLogin(@RequestBody String userList) throws Exception {
        logger.info("====================sync user,start========================");
        JSONArray array = JSONArray.parseArray(userList);
        if(!CollectionUtils.isEmpty(array)) {
            for (Object obj : array) {
                JsonObject json = (JsonObject)obj;
                logger.info("user:{}",json.toString());
                LianzhengUserEntity entity = new LianzhengUserEntity();
                entity.setFid(json.getAsJsonObject("fid").toString());
                entity.setUsername(json.getAsJsonObject("usernumber").toString());
                entity.setMobile(json.getAsJsonObject("fcell").toString());
                entity.setMobile(json.getAsJsonObject("femail").toString());
                entity.setStatus(UserStatusCode.NORMAL_USER.getCode());
                if(StringUtils.isEmpty(json.getAsJsonObject("fid").toString())){
                    //保存新增数据
                    String id = IdWorker.getIdStr();
                    entity.setUserId(id);
                    String salt = RandomStringUtils.randomAlphanumeric(20);
                    entity.setPassword(new Sha256Hash("000000", salt).toHex()); //设置初始密码 000000
                    entity.setSalt(salt);
                    entity.setStatus(UserStatusCode.NORMAL_USER.getCode());
                    entity.setCreateTime(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
                    entity.setUpdateTime(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
                    this.lianzhengUserService.save(entity);
                }else{
                    //保存更新数据
                    entity.setUpdateTime(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
                    this.lianzhengUserService.updateUserByfid(entity);
                }
            }
        }
        logger.info("====================sync user,end==========================");
        return R.ok();
    }
}
