package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEffectivePeriodEntity;

public interface LianzhengReferenceEffectivePeriodService extends IService<LianzhengReferenceEffectivePeriodEntity> {
    LianzhengReferenceEffectivePeriodEntity getLianzhengReferenceEffectivePeriod(String lianzhengReferenceId);
    void updateLianzhengReferenceEffectivePeriod(LianzhengReferenceEffectivePeriodEntity lzReferenceEffectivePeriodEntity);
}
