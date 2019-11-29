package com.yugao.lianzheng.modules.sys.controller;


import cn.hutool.core.io.FileUtil;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengFileEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作管理
 *
 * @author xiaoshiyu
 * @date 2019-09-22
 */


@Controller
@RequestMapping("/file")
@Slf4j
public class FileController extends AbstractController {

    @Autowired
    private LianzhengFileService fileInfoService;

    @Value("${uploadFile.path}")
    private String localPath;

    @Value("${uploadFile.size}")
    private int limitSize;

    /**
     * 预览文件
     *
     * @return
     */
    @GetMapping("/preview")
    public void open(HttpServletResponse response, @Param("businessId") String businessId,@Param("moduleId") String moduleId) throws IOException {
        LianzhengFileEntity entity = fileInfoService.getFile(businessId,moduleId);
        if (null == entity || null == entity.getPath()) {
            fileIsExist(response);
            return;
        }


        // 清空response
        response.reset();
        // 设置编码
        response.setCharacterEncoding("UTF-8");

        String contentType;
        String fileName = entity.getName();
        if (fileName.toUpperCase().endsWith(".PDF")) {
            contentType = "application/pdf";
        } else if (fileName.toUpperCase().endsWith(".PNG")) {
            contentType = "image/png";
        } else if(fileName.toUpperCase().endsWith(".JPEG")||fileName.toUpperCase().endsWith(".JPG")){
            contentType = "image/jpeg";
        } else if(fileName.toUpperCase().endsWith(".BMP")){
            contentType = "application/x-bmp";
        } else if(fileName.toUpperCase().endsWith(".TXT")){
            contentType = "text/plain";
        } else if(fileName.toUpperCase().endsWith(".JSON")){
            contentType = "application/json";
        } else if(fileName.toUpperCase().endsWith(".MD")){
            contentType= "application/x-genesis-rom";
        } else {
            contentType = "*/*";
        }
        //注意contentType类型
        response.setContentType(contentType);
        response.setHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode(entity.getName(), "UTF-8"));

        doFile(response, entity);
    }

    /**
     * 下载文件
     *
     * @return
     */
    @GetMapping("/download")
    public void download(HttpServletResponse response, @Param("businessId") String businessId,@Param("moduleId") String moduleId) throws IOException {
        LianzhengFileEntity entity = fileInfoService.getFile(businessId,moduleId);
        if (null == entity || null == entity.getPath()) {
            fileIsExist(response);
            return;
        }

        // 清空response
        response.reset();
        response.setContentType("application/x-download");
        // 设置编码
        response.setCharacterEncoding("UTF-8");

        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(entity.getName(), "UTF-8"));

        doFile(response, entity);
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
            LianzhengFileEntity fileInfo = this.fileInfoService.uploadFile(file,user);
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
     * 根据用户ID获取文件列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    @ResponseBody
    public R queryFileList(@Param("businessId") String businessId,
                           @Param("moduleId") String moduleId,
                           @Param("createdBy") String createdBy,
                           @Param("page") int page,
                           @Param("size") int size){
        LianzhengUserEntity user=getUser();
        createdBy = createdBy == null || createdBy.length()<=0 ? String.valueOf(user.getLianzhengUserId()) : createdBy;
        page =  page >1 ? page : 1;
        size =  size >0 ? size : 20;
        int toIndexNum = (page -1) * size;
        List<LianzhengFileEntity> list=this.fileInfoService.queryFileList(businessId, moduleId, createdBy,toIndexNum,size);
        if(list==null){
            return R.ok().put("data",new ArrayList<>());
        }else{
            return R.ok().put("data",list);
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

    private void fileIsExist(HttpServletResponse response) {
        try {
            OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
            String data = "<script language='javascript'>alert(\"\\u64cd\\u4f5c\\u5f02\\u5e38\\uff01\");</script>";
            writer.write(data);
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void doFile(HttpServletResponse response, LianzhengFileEntity entity) {
        try {
            OutputStream out = new BufferedOutputStream(response.getOutputStream());

            InputStream in = FileUtil.getInputStream(new File(entity.getPath()));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            out.close();
            in.close();

        } catch (IOException e) {
            try {
                OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
                String data = "<script language='javascript'>alert(\"\\u64cd\\u4f5c\\u5f02\\u5e38\\uff01\");</script>";
                writer.write(data);
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


}
