package com.yugao.lianzheng.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.modules.sys.dao.LianzhengFileDao;
import com.yugao.lianzheng.modules.sys.entity.LianzhengFileEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LianzhengFileServiceImpl extends ServiceImpl<LianzhengFileDao, LianzhengFileEntity> implements LianzhengFileService {

    /**本地存储路径*/
    @Value("${uploadFile.path}")
    private String uploadLocal;


    @Autowired
    private LianzhengFileDao fileInfoDao;

    @Override
    public LianzhengFileEntity uploadFile(MultipartFile file, LianzhengUserEntity entity) {

            //生成文件的唯一id
            String fileId = IdWorker.getIdStr();

            //获取文件后缀

            String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            //获取文件原始名称
            String originalFilename = file.getOriginalFilename();

            //生成文件的最终名称
            String finalName = fileId + "." + fileSuffix;
            //保存文件信息
        LianzhengFileEntity fileInfo =null;
            try {
                //保存文件到指定目录
                //创建日期目录,将文件按月份类存方
                LocalDateTime now = LocalDateTime.now();
                int year = now.getYear();
                int monthValue = now.getMonthValue();
                String fileSavePath = uploadLocal+year+ File.separator+monthValue+File.separator+finalName;
                //判断目录是否存在，不存在创建
                File makeDatePath=new File(uploadLocal+year+ File.separator+monthValue+File.separator);
                if (!makeDatePath.exists()) {
                    boolean res = makeDatePath.mkdirs();
                }
                File newFile = new File(fileSavePath);
                file.transferTo(newFile);
                fileInfo= new LianzhengFileEntity();
                fileInfo.setLianzhengFileId(fileId);
                fileInfo.setName(originalFilename);
                fileInfo.setSuffix(fileSuffix);
                fileInfo.setPath(uploadLocal+year+"/"+monthValue+"/"+finalName);
                fileInfo.setFinalName(finalName);
                fileInfo.setStatus(1);//文件状态 1正常0删除
                fileInfo.setCreatedBy(entity.getLianzhengUserId().intValue());
                fileInfo.setCreatedAt(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
                //计算文件大小kb
                long kb = new BigDecimal(file.getSize())
                        .divide(BigDecimal.valueOf(1024))
                        .setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
                fileInfo.setSize(kb);
                this.save(fileInfo);
            } catch (Exception e) {
                log.error("上传文件错误！", e);
            }
        return fileInfo;
    }


    /**
     * 删除文件，该处做逻辑删除，文件状态 1正常 -1 已删除
     */
    @Override
    public void deleteFile(String id) {
        this.fileInfoDao.deleteFileById(id);
    }

    @Override
    public List<LianzhengFileEntity> queryFileList(String businessId, String moduleId, String createdBy) {
        return this.fileInfoDao.getFileList(businessId, moduleId, createdBy);
    }

    /**
     * 获取当前日期年月路径存放文件 如2019/9/
     * @return
     */
    public String getCurDatePath(){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        return year+File.separator+month+File.separator;
    }

    @Override
    public LianzhengFileEntity getFileByFileId(String fileId) {
        LianzhengFileEntity entity = fileInfoDao.findById(fileId);
        return entity;
    }

    @Override
    public void updateFile(LianzhengFileEntity entity){
        fileInfoDao.updateFile(entity);
    }
}
