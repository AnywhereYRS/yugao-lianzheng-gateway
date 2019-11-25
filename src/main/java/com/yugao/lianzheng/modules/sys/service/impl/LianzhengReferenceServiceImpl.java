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
    public List<LianzhengReferenceEntity> getLianzhengReferenceList(int type, String department, String project, String pattern,int page,int size){
        return lzReferenceDao.getLianzhengReferenceList(type, department, project, pattern,page,size);
    }

    @Override
    public long getLianzhengReferenceListCount(int type, String department, String project, String pattern){
        return lzReferenceDao.getLianzhengReferenceListCount(type, department, project, pattern);
    }

    @Override
    public void updateLianzhengReference(LianzhengReferenceEntity lzReferenceEntity){
        lzReferenceDao.updateLianzhengReference(lzReferenceEntity);
    }

    @Override
    public void deteleLianzhengReference(int id){
        lzReferenceDao.deteleLianzhengReference(id);
    }

    @Override
    public LianzhengReferenceEntity getLianzhengReferenceDetail(int id){
        return lzReferenceDao.getLianzhengReferenceDetail(id);
    }
}
