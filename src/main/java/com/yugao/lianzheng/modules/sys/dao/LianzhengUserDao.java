package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserRoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LianzhengUserDao extends BaseMapper<LianzhengUserEntity>  {
    void updateUser(@Param("entity") LianzhengUserEntity entity);
    void updateUserByfid(@Param("entity") LianzhengUserEntity entity);
    List<LianzhengUserEntity> queryList(@Param("status") String status,
                                           @Param("page") int page,
                                           @Param("size") int size);
    long queryListCount( @Param("status") String status);
    LianzhengUserEntity getDetailByUserId(@Param("userId") String userId);
    LianzhengUserEntity getDetailByUserName(@Param("userName") String userName);
    LianzhengUserEntity getDetailByMobile(@Param("mobile") String mobile);
}
