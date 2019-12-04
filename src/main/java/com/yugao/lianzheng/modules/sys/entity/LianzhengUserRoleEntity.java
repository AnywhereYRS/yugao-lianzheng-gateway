/**
 * Copyright (c) 2019 快速开发框架 All rights reserved.
 */

package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 系统用户
 *
 * @author yangrenshan
 */
@Data
@ToString
@TableName("sys_user_role")
public class LianzhengUserRoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;

}
