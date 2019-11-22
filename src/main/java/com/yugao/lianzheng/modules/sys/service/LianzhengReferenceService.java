package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEntity;

import java.util.List;

public interface LianzhengReferenceService extends IService<LianzhengReferenceEntity> {
    List<LianzhengReferenceEntity> getLianzhengReferenceList(int type, String department, String project, String pattern);
    void updateLianzhengReference(LianzhengReferenceEntity lzReferenceEntity);
    void deteleLianzhengReference(int id);
    LianzhengReferenceEntity getLianzhengReferenceDetail(int id);
}
