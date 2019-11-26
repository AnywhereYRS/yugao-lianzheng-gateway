package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUndoEntity;

import java.util.List;

public interface LianzhengUndoService extends IService<LianzhengUndoEntity> {
    void updateLianzhengUndoEntity(LianzhengUndoEntity lzUndoEntity);
    List<LianzhengUndoEntity> queryList(String lianzhengReferenceId, String type, String dueBy, String finishedBy, String status,int page,int size);
    long queryListCount(String lianzhengReferenceId, String type, String dueBy, String finishedBy, String status);
    void deleteLianzhengUndoEntity(String id);
}
