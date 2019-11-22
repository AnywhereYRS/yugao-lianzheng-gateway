package com.yugao.lianzheng.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 廉政资料的生效时段（针对廉政告知函）
 * </p>
 *
 * @author lihong
 * @since
 */

@Data
@TableName("lianzheng_reference_effective_period")
public class LianzhengReferenceEffectivePeriodEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @TableId
    private String lianzhengReferenceEffectivePeriodId;
    /**
     * 廉政主体信息的id
     */
    private String lianzhengReferenceId;

    /**
     * 开始时间
     */
    private String dateFrom;

    /**
     * 结束时间
     */
    private String dateTo;

    /**
     * 状态：1-正常，-1-删除
     */
    private int status;

    /**
     * 备注说明
     */
    private String remarks;
}
