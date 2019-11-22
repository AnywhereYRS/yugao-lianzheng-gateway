package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LianzhengReferenceDao extends BaseMapper<LianzhengReferenceEntity> {
    List<LianzhengReferenceEntity> getLianzhengReferenceList(@Param("type") int type, @Param("department") String department, @Param("project") String project, @Param("pattern") String pattern);
    void updateLianzhengReference(@Param("lzReferenceEntity") LianzhengReferenceEntity lzReferenceEntity);
    void deteleLianzhengReference(@Param("id") int id);
    LianzhengReferenceEntity getLianzhengReferenceDetail(@Param("id") int id);
}
