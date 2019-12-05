package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserRoleEntity;

import java.util.List;

public interface LianzhengUserService extends IService<LianzhengUserEntity> {
    void updateUser(LianzhengUserEntity entity);
    void updateUserByfid(LianzhengUserEntity entity);
    List<LianzhengUserEntity> queryList(String status, int page, int size);
    long queryListCount( String status);
    LianzhengUserEntity getDetailByUserId(String userId);
    LianzhengUserEntity getDetailByUserName(String userName);
    LianzhengUserEntity getDetailByMobile(String mobile);
}
