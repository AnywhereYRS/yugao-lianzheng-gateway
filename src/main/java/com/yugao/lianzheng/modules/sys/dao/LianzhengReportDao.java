package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReportEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LianzhengReportDao extends BaseMapper<LianzhengReportEntity> {
    List<LianzhengReportEntity> getLianzhengReportList(@Param("page") int page,@Param("size") int size);
    long getLianzhengReportListCount();
    void updateLianzhengReport(@Param("entity") LianzhengReportEntity entity);
    void deteleLianzhengReport(@Param("id") long id);
    LianzhengReportEntity getLianzhengReportDetail(@Param("id") long id);
}
