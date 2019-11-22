package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 * 廉政动态表
 * </p>
 *
 * @author lihong
 * @since
 */

@Data
@TableName("lianzheng_dongtai")
public class LianzhengDongtaiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private String lianzhengDongtaiId;
    /**
     * 廉政动态的标题
     */
    private String title;

    /**
     * 廉政动态的内容
     */
    private String content;

    /**
     * 廉政动态的类型
     */
    private int type;

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
