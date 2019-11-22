package com.yugao.lianzheng.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 文件信息表
 Mapper 接口
 * </p>
 *
 * @author lihong
 * @since
 */
@Mapper
public interface LianzhengFileDao extends BaseMapper<LianzhengFileEntity> {

    LianzhengFileEntity findById(@Param("id") String id);
    void deleteFileById(@Param("id") String id);
    List<LianzhengFileEntity> getFileList(@Param("businessId") String businessId, @Param("moduleId") String moduleId, @Param("createdBy") String createdBy);
}
