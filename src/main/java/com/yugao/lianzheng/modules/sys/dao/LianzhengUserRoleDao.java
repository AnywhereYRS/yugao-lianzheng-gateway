package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserRoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LianzhengUserRoleDao extends BaseMapper<LianzhengUserRoleEntity>  {
    void deleteUserRole(@Param("userId") String userId,@Param("roleId") String roleId);
    List<LianzhengUserRoleEntity> queryListUserRole(@Param("userId") String userId,@Param("roleId") String roleId);
}
