package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceTypeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LianzhengReferenceTypeDao extends BaseMapper<LianzhengReferenceTypeEntity> {
    List<LianzhengReferenceTypeEntity> getLianzhengReferenceTypeList();
}
