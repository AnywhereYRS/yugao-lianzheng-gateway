package com.yugao.lianzheng.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugao.lianzheng.modules.sys.entity.LianzhengDongtaiImgEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LianzhengDongtaiImgDao extends BaseMapper<LianzhengDongtaiImgEntity> {
    List<LianzhengDongtaiImgEntity> getLianzhengDongtaiByMainId(@Param("mainId") String mainId);
    void deleteLianzhengDongtaiImg(@Param("id")String id);
    void clearLianzhengDongtaiImgsByMainId(@Param("mainId")String mainId);
}
