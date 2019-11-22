package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengDongtaiImgEntity;
import java.util.List;

public interface LianzhengDongtaiImgService  extends IService<LianzhengDongtaiImgEntity> {
    List<LianzhengDongtaiImgEntity> getLianzhengDongtaiByMainId(String mainId);
    void deleteLianzhengDongtaiImg(String id);
    void clearLianzhengDongtaiImgsByMainId(String mainId);
}
