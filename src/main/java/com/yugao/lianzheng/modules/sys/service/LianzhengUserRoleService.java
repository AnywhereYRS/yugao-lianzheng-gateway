package com.yugao.lianzheng.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserRoleEntity;

import java.util.List;

public interface LianzhengUserRoleService extends IService<LianzhengUserRoleEntity> {
    void deleteUserRole(String userId,String roleId);
    List<LianzhengUserRoleEntity> queryListUserRole(String userId,String roleId);
}
