package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengDongtaiEntity;

import java.util.List;

public interface LianzhengDongtaiService extends IService<LianzhengDongtaiEntity> {
    void updateLianzhengDongtai(LianzhengDongtaiEntity entity);
    List<LianzhengDongtaiEntity> queryList(String createdBy, String beginTime, String endTime, String pattern, String status,int page,int size);
    long queryListCount(String createdBy, String beginTime, String endTime, String pattern, String status);
    void deleteLianzhengDongtai(String id);
    LianzhengDongtaiEntity getLianzhengDongtaiDetail(String id);
}
