package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEffectivePeriodEntity;
import org.apache.ibatis.annotations.Param;

public interface LianzhengReferenceEffectivePeriodDao extends BaseMapper<LianzhengReferenceEffectivePeriodEntity> {
    LianzhengReferenceEffectivePeriodEntity getLianzhengReferenceEffectivePeriod(@Param("lianzhengReferenceId") String lianzhengReferenceId);
    void updateLianzhengReferenceEffectivePeriod(@Param("lzReferenceEffectivePeriodEntity") LianzhengReferenceEffectivePeriodEntity lzReferenceEffectivePeriodEntity);
}
