package com.yugao.lianzheng.modules.sys.controller;


import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengFileEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.model.FileStatusCode;
import com.yugao.lianzheng.modules.sys.service.LianzhengFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件操作管理
 *
 * @author yangrenshan
 * @date 2019-09-22
 */


@Controller
@RequestMapping("/means")
@Slf4j
public class MeansModuleController extends AbstractController {

    @Autowired
    private LianzhengFileService fileInfoService;

    @Value("${uploadFile.path}")
    private String localPath;

    @Value("${uploadFile.size}")
    private int limitSize;


    /**
     * 新增文件
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/save")
    @ResponseBody
    public R saveFile(@Param("fileId") String fileId,@Param("title") String title){
        LianzhengFileEntity entity=new LianzhengFileEntity();
        entity.setLianzhengFileId(fileId);
        entity.setRemarks(title);
        this.fileInfoService.updateFile(entity);
        return R.ok();
    }

    /**
     * 通用文件上传接口
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    public R fileUpload(@RequestPart("file") MultipartFile file) {
        LianzhengUserEntity user=getUser();
        if(file!=null){
            if(file.getSize()>=limitSize){
                return R.error("上传文件大小不得超20M");
            }
            LianzhengFileEntity fileInfo = this.fileInfoService.uploadFileNew(file,user);
            if(fileInfo!=null){
                return R.ok().put("data",fileInfo);
            }else{
                return R.error("文件上传失败");
            }
        }else{
            return R.error("文件上传失败");
        }

    }

    /**
     * 删除文件
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/delete")
    @ResponseBody
    public R deleteFileById(@Param("fileId") String fileId){
        LianzhengFileEntity entity=new LianzhengFileEntity();
        this.fileInfoService.deleteFile(fileId);
        return R.ok();
    }

    /**
     * 发布文件
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/publish")
    @ResponseBody
    public R publishFileById(@Param("fileId") String fileId){
        LianzhengFileEntity entity=new LianzhengFileEntity();
        entity.setLianzhengFileId(fileId);
        entity.setStatus(FileStatusCode.HAVETO_PUBLISH.getCode());
        this.fileInfoService.updateFile(entity);
        return R.ok();
    }

    /**
     * 取消发布文件
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/cancle")
    @ResponseBody
    public R cancleFileById(@Param("fileId") String fileId){
        LianzhengFileEntity entity=new LianzhengFileEntity();
        entity.setLianzhengFileId(fileId);
        entity.setStatus(FileStatusCode.WAIT_PUBLISH.getCode());
        this.fileInfoService.updateFile(entity);
        return R.ok();
    }

}
