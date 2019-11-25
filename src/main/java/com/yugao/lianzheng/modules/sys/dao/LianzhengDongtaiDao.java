package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengDongtaiEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LianzhengDongtaiDao extends BaseMapper<LianzhengDongtaiEntity>  {
    void updateLianzhengDongtai(@Param("lianzhengDongtaiEntity") LianzhengDongtaiEntity entity);
    List<LianzhengDongtaiEntity> queryList(@Param("createdBy") String createdBy,
                                           @Param("beginTime") String beginTime,
                                           @Param("endTime") String endTime,
                                           @Param("pattern") String pattern,
                                           @Param("status") String status,
                                           @Param("page") int page,
                                           @Param("size") int size);

    long queryListCount(@Param("createdBy") String createdBy,
                        @Param("beginTime") String beginTime,
                        @Param("endTime") String endTime,
                        @Param("pattern") String pattern,
                        @Param("status") String status);
    void deleteLianzhengDongtai(@Param("id")String id);
    LianzhengDongtaiEntity getLianzhengDongtaiDetail(@Param("id")String id);
}
