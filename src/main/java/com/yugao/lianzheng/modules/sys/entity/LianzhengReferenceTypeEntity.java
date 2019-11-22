package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 廉政资料类型
 * </p>
 *
 * @author lihong
 * @since
 */

@Data
@TableName("lianzheng_reference_type")
public class LianzhengReferenceTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private String lianzhengReferenceTypeId;
    /**
     * 描述：本阶段包括：集团资料，部门资料，项目资料
     */
    private String name;

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
     * 状态：0-草稿，1-正常，-1-删除
     */
    private int status;

    /**
     * 备注说明
     */
    private String remarks;
}
