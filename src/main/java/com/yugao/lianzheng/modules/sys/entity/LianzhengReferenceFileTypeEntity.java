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
@TableName("lianzheng_reference_file_type")
public class LianzhengReferenceFileTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private String lianzhengReferenceFileTypeId;
    /**
     * 描述：本阶段包括：廉政专题教育会图文资料、廉政约谈图文资料、廉洁从业承诺书、廉政交底现场照片、廉政告知函
     */
    private String name;

    /**
     * 指定哪些廉政资料类型可以上传该类别的附件，多类型用英文逗号(,)分割
     */
    @TableId
    private String lianzhengReferenceTypeId;

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
