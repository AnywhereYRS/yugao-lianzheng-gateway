package com.yugao.lianzheng.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yugao.lianzheng.modules.sys.entity.LianzhengFileEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * <p>
 * 文件信息表
 * 服务实现类
 * </p>
 *
 * @author lihong
 * @since
 */
@Service
public interface LianzhengFileService extends IService<LianzhengFileEntity> {

    LianzhengFileEntity uploadFile(MultipartFile file, LianzhengUserEntity entity);

    LianzhengFileEntity uploadFileNew(MultipartFile file, LianzhengUserEntity entity);

    void deleteFile(String fileId);

    void updateFile(LianzhengFileEntity entity);

    List<LianzhengFileEntity> queryFileList(String businessId, String moduleId, String status, String createdBy,int page,int size);

    long queryFileListCount(String businessId, String moduleId, String status,String createdBy);

    LianzhengFileEntity getFileByFileId(String fileId);

    LianzhengFileEntity getFile(String businessId, String moduleId);

}
