package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengContactEntity;

public interface LianzhengContactService extends IService<LianzhengContactEntity> {
    LianzhengContactEntity getLianzhengContactDetail();
    void updateLianzhengContact(LianzhengContactEntity entity);
}
