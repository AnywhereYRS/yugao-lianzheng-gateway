package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.modules.sys.dao.LianzhengUserDao;
import com.yugao.lianzheng.modules.sys.dao.LianzhengUserRoleDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserRoleEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengUserRoleService;
import com.yugao.lianzheng.modules.sys.service.LianzhengUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LianzhengUserRoleServiceImpl extends ServiceImpl<LianzhengUserRoleDao, LianzhengUserRoleEntity> implements LianzhengUserRoleService {

    @Resource
    private LianzhengUserRoleDao lianzhengUserRoleDao;

    @Override
    public void deleteUserRole(String userId,String roleId){
        lianzhengUserRoleDao.deleteUserRole(userId,roleId);
    }
    @Override
    public List<LianzhengUserRoleEntity> queryListUserRole(String userId,String roleId){
        return lianzhengUserRoleDao.queryListUserRole(userId,roleId);
    }
}
