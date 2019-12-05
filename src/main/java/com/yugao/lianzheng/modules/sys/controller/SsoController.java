package com.yugao.lianzheng.modules.sys.controller;

import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserRoleEntity;
import com.yugao.lianzheng.modules.sys.model.User;
import com.yugao.lianzheng.modules.sys.service.LianzhengUserRoleService;
import com.yugao.lianzheng.modules.sys.service.LianzhengUserService;
import com.yugao.lianzheng.utils.EncryptUtils;
import com.yugao.lianzheng.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 登录
 */
@RestController
@RequestMapping("/sso")
@Slf4j
public class SsoController{

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LianzhengUserService lianzhengUserService;

    @Autowired
    private LianzhengUserRoleService lianzhengUserRoleService;

    @Value("${lianzheng.appid}")
    private String sysAppid;

    @Value("${encrypt.key}")
    private String key;

    @Value("${expires.in}")
    private String expiresIn;

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    @ResponseBody
    public R ssoLogin(@Param("appid") String appid,@Param("mobile") String mobile) throws Exception {
        logger.info("====================login,start=======================");
        if (StringUtils.compare(sysAppid,appid) != 0) {
            return R.error("appid参数非法！");
        }
        LianzhengUserEntity userEntity = lianzhengUserService.getDetailByMobile(mobile);
        if (ObjectUtils.isEmpty(userEntity)){
            return R.error("用户手机号："+mobile+",不存在！");
        }
        logger.info("====================login,user========================");
        logger.info(userEntity.toString());
        StringBuffer token = new StringBuffer();
        token.append("userId=").append(userEntity.getUserId()).append(",");
        //token.append("userName=").append(userEntity.getUsername()).append(",");
        token.append("mobile=").append(userEntity.getMobile()).append(",");
        token.append("expiresIn=").append(expiresIn).append(",");
        token.append("loginTime=").append(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN)).append(",");
        logger.info("====================login,token=======================");
        logger.info(token.toString());
        logger.info("====================token,encrypt=====================");
        logger.info(EncryptUtils.aesEncrypt(token.toString(),key));
        List<LianzhengUserRoleEntity> roleEntities = lianzhengUserRoleService.queryListUserRole(userEntity.getUserId(),null);
        List<String> roles = new ArrayList<>();
        for (LianzhengUserRoleEntity entity : roleEntities){
            roles.add(entity.getRoleId());
        }
        logger.info("====================login,end=========================");
        return R.ok().put("token", EncryptUtils.aesEncrypt(token.toString(),key)).put("roles",roles);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/userinfo")
    @ResponseBody
    public R getUserInfo(@Param("token") String token) throws Exception {
        String tokenInfo = EncryptUtils.aesDecrypt(token,key);
        if (org.apache.commons.lang.StringUtils.isBlank(tokenInfo)){
            return R.error("token 失效");
        }
        User user = new User();
        for (String item : tokenInfo.split(",")){
            ReflectionUtils.setFieldValue(user,item.split("=")[0],item.split("=")[1]);
        }
        user.setUserName(lianzhengUserService.getDetailByUserId(user.getUserId()).getUsername());
        return R.ok().put("user",user);
    }
}
