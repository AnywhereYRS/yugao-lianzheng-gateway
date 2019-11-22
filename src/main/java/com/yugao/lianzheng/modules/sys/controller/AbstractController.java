/**
 * Copyright (c) 2019 快速开发框架 All rights reserved.
 */

package com.yugao.lianzheng.modules.sys.controller;

import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 *
 * @author Mark sunlightcs@gmail.com
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected LianzhengUserEntity getUser() {
        return (LianzhengUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    /*protected Long getUserId() {
        return getUser().getUserId();
    }*/
}
