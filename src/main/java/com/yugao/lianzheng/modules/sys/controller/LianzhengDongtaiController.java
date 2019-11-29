package com.yugao.lianzheng.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.common.utils.PageBar;
import com.yugao.lianzheng.modules.sys.entity.LianzhengDongtaiEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengFileEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.model.ModuleCode;
import com.yugao.lianzheng.modules.sys.service.LianzhengDongtaiService;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.service.LianzhengFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 廉政动态
 */
@RestController
@RequestMapping("/dongtai")
@Slf4j
public class LianzhengDongtaiController extends AbstractController{

    @Autowired(required = false)
    private LianzhengDongtaiService lzDongtaiService;

    @Autowired
    private LianzhengFileService lianzhengFileService;

    @RequestMapping(method = RequestMethod.POST, path = "/addOrUpdate")
    @ResponseBody
    public R updateNote(@RequestBody LianzhengDongtaiEntity entity) throws Exception {
        logger.debug("上传的参数信息--->"+entity.toString());
        LianzhengUserEntity user=getUser();

        // 新增廉政动态
        if(StringUtils.isBlank(entity.getLianzhengDongtaiId())){
            String content = entity.getContent();
            if(content == null || content.length() <= 0){
                return R.error(500, "请编辑廉政动态的内容");
            }
            String id = IdWorker.getIdStr();
            entity.setLianzhengDongtaiId(id);
            entity.setCreatedBy(user.getLianzhengUserId().intValue());
            entity.setUpdatedBy(user.getLianzhengUserId().intValue());
            entity.setCreatedAt(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            entity.setUpdatedAt(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            entity.setStatus(1);
            entity.setType(0);
            this.lzDongtaiService.save(entity);
            if (StringUtils.isNotBlank(entity.getImageId())){
                LianzhengFileEntity imagEntity = new LianzhengFileEntity();
                imagEntity.setLianzhengFileId(entity.getImageId());
                imagEntity.setBusinessId(id);
                imagEntity.setModuleId(String.valueOf(ModuleCode.LIANZHENG_IMG.getCode()));
                lianzhengFileService.updateFile(imagEntity);
            }
            if (StringUtils.isNotBlank(entity.getFileId())){
                LianzhengFileEntity fileEntity = new LianzhengFileEntity();
                fileEntity.setLianzhengFileId(entity.getFileId());
                fileEntity.setBusinessId(id);
                fileEntity.setModuleId(String.valueOf(ModuleCode.LIANZHENG_NEWS.getCode()));
                lianzhengFileService.updateFile(fileEntity);
            }
            return R.ok().put("data", entity);
        }
        //更新廉政动态
        else{
            this.lzDongtaiService.updateLianzhengDongtai(entity);
            return R.ok().put("data",entity);
        }
    }


    @RequestMapping(method = RequestMethod.GET, path = "/findById")
    @ResponseBody
    public R queryByID(@Param("id") String id) {
        LianzhengUserEntity user=getUser();
        LianzhengDongtaiEntity entity=this.lzDongtaiService.getLianzhengDongtaiDetail(id);
        return R.ok().put("data",entity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findList")
    @ResponseBody
    public R queryList(@Param("beginTime") String beginTime,
                       @Param("endTime") String endTime,
                       @Param("pattern") String pattern,
                       @Param("status") String status,
                       @Param("page") int page,
                       @Param("size") int size) throws Exception {
        LianzhengUserEntity user=getUser();

        status = (status == null || status.length()<=0) ? "1" : status;
        page =  page >1 ? page : 1;
        size =  size >0 ? size : 20;
        int toIndexNum = (page -1) * size;
        List<LianzhengDongtaiEntity> list=this.lzDongtaiService.queryList(String.valueOf(user.getLianzhengUserId()), beginTime, endTime, pattern, status,toIndexNum,size);

        PageBar pagebar = new PageBar();
        pagebar.setPage(page);
        pagebar.setSize(size);
        pagebar.setTotal(lzDongtaiService.queryListCount(String.valueOf(user.getLianzhengUserId()), beginTime, endTime, pattern, status));
        return R.ok().put("list",list).put("pagebar",pagebar);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete")
    @ResponseBody
    public R deleteLianzhengDongtai(@Param("id") String id) throws Exception {
        LianzhengUserEntity user=getUser();

        this.lzDongtaiService.deleteLianzhengDongtai(id);
        return R.ok();
    }
}
