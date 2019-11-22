package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceFileTypeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LianzhengReferenceFileTypeDao extends BaseMapper<LianzhengReferenceFileTypeEntity> {
    List<LianzhengReferenceFileTypeEntity> getLianzhengReferenceFileTypeList(@Param("lianzhengReferenceTypeId") String lianzhengReferenceTypeId);
}
