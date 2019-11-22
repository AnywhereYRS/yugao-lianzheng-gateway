package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
@TableName("lianzheng_undo")
public class LianzhengUndoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private String lianzhengUndoId;
    /**
     * 廉政主体信息的id
     */
    private String lianzhengReferenceId;

    /**
     * 类型：1-待阅(审阅，查看确认即可)，2-待办(需要审批)
     */
    private int type;

    /**
     * 任务预计处理人
     */
    private long dueBy;

    /**
     * 任务实际处理人
     */
    private long finishedBy;

    /**
     * 任务预计完成时间
     */
    private String dueAt;

    /**
     * 任务完成时间
     */
    private String finishedAt;

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
