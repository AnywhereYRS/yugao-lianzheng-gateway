package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.modules.sys.dao.LianzhengReferenceFileTypeDao;
import com.yugao.lianzheng.modules.sys.dao.LianzhengReferenceTypeDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceFileTypeEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceTypeEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceFileTypeService;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LianzhengReferenceFileTypeServiceImpl extends ServiceImpl<LianzhengReferenceFileTypeDao, LianzhengReferenceFileTypeEntity> implements LianzhengReferenceFileTypeService {
    @Autowired
    private LianzhengReferenceFileTypeDao lzReferenceFileTypeDao;

    @Override
    public List<LianzhengReferenceFileTypeEntity> getLianzhengReferenceFileTypeList(String lianzhengReferenceTypeId){
        return lzReferenceFileTypeDao.getLianzhengReferenceFileTypeList(lianzhengReferenceTypeId);
    }
}
