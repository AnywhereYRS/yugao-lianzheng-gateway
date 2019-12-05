/**
 * Copyright (c) 2019 快速开发框架 All rights reserved.
 */

package com.yugao.lianzheng.modules.sys.controller;

import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.model.User;
import com.yugao.lianzheng.utils.EncryptUtils;
import com.yugao.lianzheng.utils.ReflectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Controller公共组件
 *
 * @author yangrenshan
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    private final static ThreadLocal<HttpServletRequest> requestContainer = new ThreadLocal<>();

    private final static ThreadLocal<HttpServletResponse> responseContainer = new ThreadLocal<>();

    private final static ThreadLocal<HttpSession> sessionContainer = new ThreadLocal<>();

    private final static ThreadLocal<User> userInfoContainer = new ThreadLocal<>();


    @Value("${encrypt.key}")
    private String key;


    protected LianzhengUserEntity getUser() {
        User loginInfo = userInfoContainer.get();
        LianzhengUserEntity user = new LianzhengUserEntity();
        user.setUserId(loginInfo.getUserId());
        user.setUsername(loginInfo.getUserName());
        return user;
    }

    @ModelAttribute
    public void checkLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws Exception {
        requestContainer.set(request);
        responseContainer.set(response);
        sessionContainer.set(session);
        logger.info("===============================================");
        logger.info("request:{}",request.getContextPath());
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return;
        }
        logger.info("token:{}",token);
        String tokenInfo = EncryptUtils.aesDecrypt(token,key);
        if (StringUtils.isBlank(tokenInfo)){
            throw new Exception("token 无效！");
        }
        logger.info("tokenInfo:{}",tokenInfo);
        User user = new User();
        for (String item : tokenInfo.split(",")){
            ReflectionUtils.setFieldValue(user,item.split("=")[0],item.split("=")[1]);
        }
        if (!checkExpiresIn(user.getExpiresIn(),user.getLoginTime())) {
            throw new Exception("登录失效，请重新登陆！");
        }
        logger.info("===============================================");
        userInfoContainer.set(user);
    }

    private boolean checkExpiresIn(String expiresIn,String loginTime){
        long expiresT = Long.parseLong(expiresIn);
        logger.info("expiresTime:{}",expiresT);
        long nowT = new Date().getTime();
        logger.info("nowTime:{}",nowT);
        long loginT = DateUtils.stringToDate(loginTime,DateUtils.DATE_TIME_PATTERN).getTime();
        logger.info("loginTime:{}",loginT);
        if ((nowT - loginT)/1000 > expiresT){
            return false;
        }else {
            return true;
        }
    }
}
