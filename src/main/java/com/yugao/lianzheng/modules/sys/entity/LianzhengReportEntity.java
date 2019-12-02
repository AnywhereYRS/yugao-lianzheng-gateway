package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 廉政报告实体
 * </p>
 *
 * @author yangrenshan
 * @since
 */

@Data
@TableName("lianzheng_report")
public class LianzhengReportEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 报告ID
     */
    @TableId
    private String reportId;
    /**
     * 报告标题
     */
    private String reportTitle;

    /**
     * 报告周期开始时间
     */
    private String fromDate;

    /**
     * 报告周期截至时间
     */
    private String toDate;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 报告创建人ID
     */
    private int createUserId;

    /**
     * 报告创建人名称
     */
    private String createUserName;

    /**
     *报告状态编码 0：未发布 1：已发布 2：已删除
     */
    private int statusCode;

    /**
     *报告状态描述
     */
    private String statusDesc;

    /**
     *报告更新时间
     */
    private String updateDate;

    /**
     * 报告更新人ID
     */
    private int updateUserId;

    /**
     * 报告更新人名称
     */
    private String updateUserName;

    /**
     * 附件ID
     */
    @TableField(exist = false)
    private String fileId;

    /**
     * 附件信息
     */
    @TableField(exist = false)
    private List<LianzhengFileEntity> fileEntity;

}
