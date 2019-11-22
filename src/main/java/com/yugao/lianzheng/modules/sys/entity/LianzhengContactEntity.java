package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 廉政信箱
 * </p>
 *
 * @author lihong
 * @since
 */

@Data
@TableName("lianzheng_contact")
public class LianzhengContactEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private String lianzhengContactId;
    /**
     * 联系电话
     */
    private String telNo;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 联系人邮箱
     */
    private String email;

    /**
     * 创建者id
     */
    private int createdBy;

    /**
     * 创建时间
     */
    private String createdAt;

    /**
     * 最后一次修改者id
     */
    private int updatedBy;

    /**
     * 最后一次修改时间
     */
    private String updatedAt;

    /**
     * 状态：0-草稿，1-已发布，-1-删除
     */
    private int status;

    /**
     * 备注说明
     */
    private String remarks;
}
