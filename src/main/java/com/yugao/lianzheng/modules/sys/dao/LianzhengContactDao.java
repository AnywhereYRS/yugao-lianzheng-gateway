package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengContactEntity;
import org.apache.ibatis.annotations.Param;

public interface LianzhengContactDao extends BaseMapper<LianzhengContactEntity> {
    LianzhengContactEntity getLianzhengContactDetail();
    void updateLianzhengContact(@Param("lianzhengContactEntity") LianzhengContactEntity lianzhengContactEntity);
}
