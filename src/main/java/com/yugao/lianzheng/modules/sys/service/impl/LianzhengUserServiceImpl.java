package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.modules.sys.dao.LianzhengUserDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LianzhengUserServiceImpl extends ServiceImpl<LianzhengUserDao, LianzhengUserEntity> implements LianzhengUserService {

    @Resource
    private LianzhengUserDao lianzhengUserDao;

    @Override
    public void updateUser(LianzhengUserEntity entity){
        lianzhengUserDao.updateUser(entity);
    }

    @Override
    public void updateUserByfid(LianzhengUserEntity entity){
        lianzhengUserDao.updateUserByfid(entity);
    }
    @Override
    public List<LianzhengUserEntity> queryList(String status, int page, int size){
        return lianzhengUserDao.queryList(status,page,size);
    }
    @Override
    public long queryListCount( String status){
        return lianzhengUserDao.queryListCount(status);
    }
    @Override
    public LianzhengUserEntity getDetailByUserId(String userId){
        return lianzhengUserDao.getDetailByUserId(userId);
    }
    @Override
    public LianzhengUserEntity getDetailByUserName(String username){
        return lianzhengUserDao.getDetailByUserName(username);
    }

    @Override
    public LianzhengUserEntity getDetailByMobile(String mobile){
        return lianzhengUserDao.getDetailByMobile(mobile);
    }
}
