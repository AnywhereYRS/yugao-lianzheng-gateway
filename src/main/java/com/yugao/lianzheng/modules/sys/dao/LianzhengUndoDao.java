package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengDongtaiEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUndoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LianzhengUndoDao extends BaseMapper<LianzhengUndoEntity>  {
    void updateLianzhengUndoEntity(@Param("lzUndoEntity") LianzhengUndoEntity lzUndoEntity);
    List<LianzhengUndoEntity> queryList(@Param("lianzhengReferenceId") String lianzhengReferenceId,
                                        @Param("type") String type,
                                        @Param("dueBy") String dueBy,
                                        @Param("finishedBy") String finishedBy,
                                        @Param("status") String status,
                                        @Param("page") int page,
                                        @Param("size") int size);
    long queryListCount(@Param("lianzhengReferenceId") String lianzhengReferenceId,
                                        @Param("type") String type,
                                        @Param("dueBy") String dueBy,
                                        @Param("finishedBy") String finishedBy,
                                        @Param("status") String status);
    void deleteLianzhengUndoEntity(@Param("id") String id);
}
