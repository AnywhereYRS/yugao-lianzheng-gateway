package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceTypeEntity;

import java.util.List;

public interface LianzhengReferenceTypeService extends IService<LianzhengReferenceTypeEntity> {
    List<LianzhengReferenceTypeEntity> getLianzhengReferenceTypeList();
}
