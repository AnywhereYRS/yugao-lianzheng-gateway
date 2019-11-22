package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.modules.sys.dao.LianzhengContactDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengContactEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LianzhengContactServiceImpl extends ServiceImpl<LianzhengContactDao, LianzhengContactEntity> implements LianzhengContactService {
    @Autowired
    private LianzhengContactDao lzContactDao;

    @Override
    public LianzhengContactEntity getLianzhengContactDetail() {
        return this.lzContactDao.getLianzhengContactDetail();
    }

    @Override
    public void updateLianzhengContact(LianzhengContactEntity entity) {
        this.lzContactDao.updateLianzhengContact(entity);
    }
}
