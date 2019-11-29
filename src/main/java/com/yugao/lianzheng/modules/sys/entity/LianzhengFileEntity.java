package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文件信息表
 * </p>
 *
 * @author lihong
 * @since
 */
@Data
@TableName("lianzheng_file")
public class LianzhengFileEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "lianzheng_file_id", type = IdType.ID_WORKER)
    private String lianzhengFileId;

    /**
     * 主键id
     */
    @TableField("business_id")
    private String businessId;

    /**
     * 主键id
     */
    @TableField("module_id")
    private String moduleId;

    /**
     * 文件仓库（oss仓库）
     */
    @TableField("bucket")
    private String bucket;

    /**
     * 文件名称
     */
    @TableField("name")
    private String name;

    /**
     * 文件后缀
     */
    @TableField("suffix")
    private String suffix;

    /**
     * 文件大小kb
     */
    @TableField("size")
    private Long size;

    /**
     * 文件唯一标识id
     */
    @TableField("final_name")
    private String finalName;

    /**
     * 存储路径
     */
    @TableField("path")
    private String path;

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

    /**
     * 文件地址
     */
    @TableField(exist = false)
    private String url;


    @Override
    public String toString() {
        return "FileInfo{" +
        "fileId=" + lianzhengFileId +
        ", fileBucket=" + bucket +
        ", fileName=" + name +
        ", fileSuffix=" + suffix +
        ", fileSizeKb=" + size +
        ", finalName=" + finalName +
        ", filePath=" + path +
        ", createTime=" + createdAt +
        ", updateTime=" + updatedAt +
        ", createUser=" + createdBy +
        ", updateUser=" + updatedBy +
        ", fileState=" + status +
        "}";
    }
}
