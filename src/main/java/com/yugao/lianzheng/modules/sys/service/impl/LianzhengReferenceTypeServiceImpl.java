package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.modules.sys.dao.LianzhengReferenceTypeDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceTypeEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LianzhengReferenceTypeServiceImpl extends ServiceImpl<LianzhengReferenceTypeDao, LianzhengReferenceTypeEntity> implements LianzhengReferenceTypeService {
    @Autowired
    private LianzhengReferenceTypeDao lzReferenceTypeDao;

    @Override
    public List<LianzhengReferenceTypeEntity> getLianzhengReferenceTypeList(){
        return lzReferenceTypeDao.getLianzhengReferenceTypeList();
    }
}
