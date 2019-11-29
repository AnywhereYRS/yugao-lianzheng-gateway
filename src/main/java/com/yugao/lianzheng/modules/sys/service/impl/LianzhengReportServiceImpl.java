package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.modules.sys.dao.LianzhengReferenceDao;
import com.yugao.lianzheng.modules.sys.dao.LianzhengReportDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReportEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceService;
import com.yugao.lianzheng.modules.sys.service.LianzhengReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LianzhengReportServiceImpl extends ServiceImpl<LianzhengReportDao, LianzhengReportEntity> implements LianzhengReportService {
    @Autowired
    private LianzhengReportDao lianzhengReportDao;

    @Override
    public List<LianzhengReportEntity> getLianzhengReportList(int page, int size){
        return lianzhengReportDao.getLianzhengReportList(page,size);
    }

    @Override
    public long getLianzhengReportListCount(){
        return lianzhengReportDao.getLianzhengReportListCount();
    }

    @Override
    public void updateLianzhengReport(LianzhengReportEntity entity){
        lianzhengReportDao.updateLianzhengReport(entity);
    }

    @Override
    public void deteleLianzhengReport(long id){
        lianzhengReportDao.deteleLianzhengReport(id);
    }

    @Override
    public LianzhengReportEntity getLianzhengReportDetail(long id){
        return lianzhengReportDao.getLianzhengReportDetail(id);
    }
}
