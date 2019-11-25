package com.yugao.lianzheng.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.common.utils.PageBar;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengDongtaiService;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 廉政资料
 */
@RestController
@RequestMapping("/reference")
@Slf4j
public class LianzhengReferenceController extends AbstractController{

    @Autowired(required = false)
    private LianzhengReferenceService lzReferenceService;

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
            entity.setCreatedBy(user.getLianzhengUserId().intValue());
            entity.setUpdatedBy(user.getLianzhengUserId().intValue());
            entity.setCreatedAt(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            entity.setUpdatedAt(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            entity.setStatus(1);
            entity.setType("0");
            this.lzReferenceService.save(entity);
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
    public R queryByID(@Param("id") int id) {
        LianzhengUserEntity user=getUser();
        LianzhengReferenceEntity entity=this.lzReferenceService.getLianzhengReferenceDetail(id);
        return R.ok().put("data",entity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findList")
    @ResponseBody
    public R queryList(@Param("type") int type,
                       @Param("department") String department,
                       @Param("project") String project,
                       @Param("pattern") String pattern,
                       @Param("page") int page,
                       @Param("size") int size) throws Exception {
        LianzhengUserEntity user=getUser();
        page =  page >1 ? page : 1;
        size =  size >0 ? size : 20;
        int toIndexNum = (page -1) * size;
        List<LianzhengReferenceEntity> list=this.lzReferenceService.getLianzhengReferenceList(type, department, project, pattern,toIndexNum,size);
        PageBar pagebar = new PageBar();
        pagebar.setPage(page);
        pagebar.setSize(size);
        pagebar.setTotal(lzReferenceService.getLianzhengReferenceListCount(type, department, project, pattern));
        return R.ok().put("list",list).put("pagebar",pagebar);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete")
    @ResponseBody
    public R deleteLianzhengReference(@Param("id") int id) throws Exception {
        LianzhengUserEntity user=getUser();

        this.lzReferenceService.deteleLianzhengReference(id);
        return R.ok();
    }
}
