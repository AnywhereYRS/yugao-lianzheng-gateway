package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEntity;

import java.util.List;

public interface LianzhengReferenceService extends IService<LianzhengReferenceEntity> {
    List<LianzhengReferenceEntity> getLianzhengReferenceList(int type, String department, String project, String patternint,int page,int size);
    long getLianzhengReferenceListCount(int type, String department, String project, String patternint);
    void updateLianzhengReference(LianzhengReferenceEntity lzReferenceEntity);
    void deteleLianzhengReference(long id);
    LianzhengReferenceEntity getLianzhengReferenceDetail(long id);
}
