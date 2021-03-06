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
    LianzhengFileEntity findByBusinessIdAndModuleId(@Param("businessId") String businessId,
                                                    @Param("moduleId") String moduleId,
                                                    @Param("fileId") String fileId);
    void deleteFileById(@Param("id") String id);
    void updateFile(@Param("entity") LianzhengFileEntity entity);
    List<LianzhengFileEntity> getFileList(@Param("businessId") String businessId,
                                          @Param("moduleId") String moduleId,
                                          @Param("status") String status,
                                          @Param("createdBy") String createdBy,
                                          @Param("page") int page,
                                          @Param("size") int size);

    long getFileListCount(@Param("businessId") String businessId,
                                          @Param("moduleId") String moduleId,
                                          @Param("createdBy") String createdBy,
                                          @Param("status") String status);
}
