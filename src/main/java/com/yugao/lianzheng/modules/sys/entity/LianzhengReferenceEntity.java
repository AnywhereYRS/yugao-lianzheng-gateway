package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 廉政资料主体信息
 * </p>
 *
 * @author lihong
 * @since
 */

@Data
@TableName("lianzheng_reference")
public class LianzhengReferenceEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private String lianzhengReferenceId;
    /**
     * 廉政资料的标题或名称
     */
    private String title;

    /**
     * 类别，对应lianzheng_reference_type中的数据
     */
    private String type;

    /**
     * 部门ID
     */
    private String departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 项目ID
     */
    private String project;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 内容和说明
     */
    private String content;

    /**
     * 创建者id
     */
    private int createdById;

    /**
     * 创建者名称
     */
    private String createdByName;

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

    /**
     * 附件ID
     */
    @TableField(exist = false)
    private String[] fileIds;

    /**
     * 资料类型
     */
    private int referenceType;

    /**
     * 附件信息
     */
    @TableField(exist = false)
    private List<LianzhengFileEntity> fileEntity;
}
