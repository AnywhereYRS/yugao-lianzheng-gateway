package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.modules.sys.dao.LianzhengReferenceEffectivePeriodDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEffectivePeriodEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceEffectivePeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LianzhengReferenceEffectivePeriodServiceImpl extends ServiceImpl<LianzhengReferenceEffectivePeriodDao, LianzhengReferenceEffectivePeriodEntity> implements LianzhengReferenceEffectivePeriodService {
    @Autowired
    private LianzhengReferenceEffectivePeriodDao lzReferenceEffectivePeriodDao;

    @Override
    public LianzhengReferenceEffectivePeriodEntity getLianzhengReferenceEffectivePeriod(String lianzhengReferenceId){
        return lzReferenceEffectivePeriodDao.getLianzhengReferenceEffectivePeriod(lianzhengReferenceId);
    }

    @Override
    public void updateLianzhengReferenceEffectivePeriod(LianzhengReferenceEffectivePeriodEntity lzReferenceEffectivePeriodEntity){
        lzReferenceEffectivePeriodDao.updateLianzhengReferenceEffectivePeriod(lzReferenceEffectivePeriodEntity);
    }
}
