package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;

/**
 * <p>
 * 廉政动态图片信息
 * </p>
 *
 * @author lihong
 * @since
 */

@Data
@TableName("lianzheng_dongtai_img")
public class LianzhengDongtaiImgEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private String lianzhengDongtaiImgId;
    /**
     * 关联外键，廉政动态的唯一标识
     */
    private String lianzhengDongtaiId;

    /**
     * 图片保存路径
     */
    private String path;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 图片大小（kb）
     */
    private long size;

    /**
     * 文件后缀
     */
    private String suffix;

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
