package com.yugao.lianzheng.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.common.utils.PageBar;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengFileEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.model.ModuleCode;
import com.yugao.lianzheng.modules.sys.service.LianzhengFileService;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * 廉政资料
 */
@RestController
@RequestMapping("/reference")
@Slf4j
public class LianzhengReferenceController extends AbstractController{

    @Autowired(required = false)
    private LianzhengReferenceService lzReferenceService;

    @Autowired
    private LianzhengFileService lianzhengFileService;

    @RequestMapping(method = RequestMethod.POST, path = "/addOrUpdate")
    @ResponseBody
    public R updateReference(@RequestBody LianzhengReferenceEntity entity) throws Exception {
        logger.debug("上传的参数信息--->"+entity.toString());
        LianzhengUserEntity user=getUser();

        // 新增廉政动态
        if(StringUtils.isBlank(entity.getLianzhengReferenceId())){
            String content = entity.getContent();
            if(content == null || content.length() <= 0){
                return R.error(500, "请编辑廉政资料的内容");
            }
            String id = IdWorker.getIdStr();
            entity.setLianzhengReferenceId(id);
            entity.setCreatedById(Integer.parseInt(user.getUserId()));
            entity.setUpdatedBy(Integer.parseInt(user.getUserId()));
            entity.setCreatedAt(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            entity.setUpdatedAt(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            entity.setStatus(1);
            entity.setType(entity.getType());
            this.lzReferenceService.save(entity);
            if (entity.getFileIds().length >0){
                for (String fildId : entity.getFileIds()){
                    LianzhengFileEntity imagEntity = new LianzhengFileEntity();
                    imagEntity.setLianzhengFileId(fildId);
                    imagEntity.setBusinessId(id);
                    imagEntity.setModuleId(String.valueOf(ModuleCode.LIANZHENG_MEANS.getCode()));
                    lianzhengFileService.updateFile(imagEntity);
                }
            }
            return R.ok().put("data", entity);
        }
        //更新廉政动态
        else{
            this.lzReferenceService.updateLianzhengReference(entity);
            return R.ok().put("data",entity);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findById")
    @ResponseBody
    public R queryByID(@Param("id") long id) {
        LianzhengUserEntity user=getUser();
        LianzhengReferenceEntity entity=this.lzReferenceService.getLianzhengReferenceDetail(id);
        entity.setCreatedAt(entity.getCreatedAt().split(" ")[0]);
        return R.ok().put("data",entity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findList")
    @ResponseBody
    public R queryList(@Param("type") String type,
                       @Param("referenceType") String referenceType,
                       @Param("department") String department,
                       @Param("project") String project,
                       @Param("pattern") String pattern,
                       @Param("page") int page,
                       @Param("size") int size) throws Exception {
        LianzhengUserEntity user=getUser();
        page =  page >1 ? page : 1;
        size =  size >0 ? size : 20;
        int toIndexNum = (page -1) * size;
        List<LianzhengReferenceEntity> list=this.lzReferenceService.getLianzhengReferenceList(type,referenceType ,department, project, pattern,toIndexNum,size);
        for (LianzhengReferenceEntity entity : list) {
            entity.setCreatedAt(entity.getCreatedAt().split(" ")[0]);
            entity.setFileEntity(lianzhengFileService.queryFileList(entity.getLianzhengReferenceId(),null,null,null,0,20));
        }
        PageBar pagebar = new PageBar();
        pagebar.setPage(page);
        pagebar.setSize(size);
        pagebar.setTotal(lzReferenceService.getLianzhengReferenceListCount(type,referenceType, department, project, pattern));
        return R.ok().put("list",list).put("pagebar",pagebar);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete")
    @ResponseBody
    public R deleteLianzhengReference(@Param("id") long id) throws Exception {
        LianzhengUserEntity user=getUser();

        this.lzReferenceService.deteleLianzhengReference(id);
        return R.ok();
    }
}
