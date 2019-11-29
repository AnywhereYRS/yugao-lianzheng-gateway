package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReportEntity;

import java.util.List;

public interface LianzhengReportService extends IService<LianzhengReportEntity> {
    List<LianzhengReportEntity> getLianzhengReportList(int page, int size);
    long getLianzhengReportListCount();
    void updateLianzhengReport(LianzhengReportEntity lzReferenceEntity);
    void deteleLianzhengReport(long id);
    LianzhengReportEntity getLianzhengReportDetail(long id);
}
