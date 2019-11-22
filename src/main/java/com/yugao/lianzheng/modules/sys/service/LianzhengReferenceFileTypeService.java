package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceFileTypeEntity;

import java.util.List;

public interface LianzhengReferenceFileTypeService extends IService<LianzhengReferenceFileTypeEntity> {
    List<LianzhengReferenceFileTypeEntity> getLianzhengReferenceFileTypeList(String lianzhengReferenceTypeId);
}
