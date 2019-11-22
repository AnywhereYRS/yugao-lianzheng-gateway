package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.modules.sys.dao.LianzhengDongtaiImgDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengDongtaiImgEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengDongtaiImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LianzhengDongtaiImgServiceImpl extends ServiceImpl<LianzhengDongtaiImgDao, LianzhengDongtaiImgEntity> implements LianzhengDongtaiImgService {
    @Autowired
    private LianzhengDongtaiImgDao lzDongtaiImgDao;

    @Override
    public List<LianzhengDongtaiImgEntity> getLianzhengDongtaiByMainId(String mainId) {
        return this.lzDongtaiImgDao.getLianzhengDongtaiByMainId(mainId);
    }

    @Override
    public void deleteLianzhengDongtaiImg(String id) {
        this.lzDongtaiImgDao.deleteLianzhengDongtaiImg(id);
    }

    @Override
    public void clearLianzhengDongtaiImgsByMainId(String mainId){
        lzDongtaiImgDao.clearLianzhengDongtaiImgsByMainId(mainId);
    }
}
