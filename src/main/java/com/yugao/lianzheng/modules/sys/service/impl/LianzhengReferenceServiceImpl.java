package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.modules.sys.dao.LianzhengReferenceDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LianzhengReferenceServiceImpl extends ServiceImpl<LianzhengReferenceDao, LianzhengReferenceEntity> implements LianzhengReferenceService {
    @Autowired
    private LianzhengReferenceDao lzReferenceDao;

    @Override
    public List<LianzhengReferenceEntity> getLianzhengReferenceList(String type,String referenceType, String department, String project, String pattern,int page,int size){
        return lzReferenceDao.getLianzhengReferenceList(type,referenceType, department, project, pattern,page,size);
    }

    @Override
    public long getLianzhengReferenceListCount(String type,String referenceType, String department, String project, String pattern){
        return lzReferenceDao.getLianzhengReferenceListCount(type,referenceType, department, project, pattern);
    }

    @Override
    public void updateLianzhengReference(LianzhengReferenceEntity lzReferenceEntity){
        lzReferenceDao.updateLianzhengReference(lzReferenceEntity);
    }

    @Override
    public void deteleLianzhengReference(long id){
        lzReferenceDao.deteleLianzhengReference(id);
    }

    @Override
    public LianzhengReferenceEntity getLianzhengReferenceDetail(long id){
        return lzReferenceDao.getLianzhengReferenceDetail(id);
    }
}
