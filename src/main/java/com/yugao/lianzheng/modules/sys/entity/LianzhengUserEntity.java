/**
 * Copyright (c) 2019 快速开发框架 All rights reserved.
 */

package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


/**
 * 系统用户
 *
 * @author yangrenshan
 */
@Data
@ToString
@TableName("sys_user")
public class LianzhengUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 创建者id
     */
    private String createdUserId;

    /**
     * 最后一次修改时间
     */
    private String updateTime;

    /**
     * 状态：1-正常，-1-禁用
     */
    private int status;

    /**
     * fid 关联同步人员表的唯一id
     */
    private String fid;
    /**
     * 用户角色信息
     */
    @TableField(exist = false)
    private List<LianzhengUserRoleEntity> roleEntityList;
}
