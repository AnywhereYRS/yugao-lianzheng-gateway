package com.yugao.lianzheng.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengDongtaiEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUndoEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengDongtaiService;
import com.yugao.lianzheng.modules.sys.service.LianzhengUndoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 待办、待阅
 */
@RestController
@RequestMapping("/undo")
@Slf4j
public class LianzhengUndoController extends AbstractController{

    @Autowired(required = false)
    private LianzhengUndoService lzUndoService;

    @RequestMapping(method = RequestMethod.POST, path = "/addOrUpdate")
    @ResponseBody
    public R updateNote(@RequestBody LianzhengUndoEntity entity) throws Exception {
        logger.debug("上传的参数信息--->"+entity.toString());
        LianzhengUserEntity user=getUser();

        // 新增廉政动态
        if(StringUtils.isBlank(entity.getLianzhengUndoId())){
            String id = IdWorker.getIdStr();
            entity.setLianzhengUndoId(id);
            entity.setCreatedBy(user.getLianzhengUserId().intValue());
            entity.setUpdatedBy(user.getLianzhengUserId().intValue());
            entity.setCreatedAt(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            entity.setUpdatedAt(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
            entity.setStatus(1);
            this.lzUndoService.save(entity);
            return R.ok().put("data", entity);
        }
        //更新廉政动态
        else{
            this.lzUndoService.updateLianzhengUndoEntity(entity);
            return R.ok().put("data",entity);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findList")
    @ResponseBody
    public R queryList(@Param("lianzhengReferenceId") String lianzhengReferenceId, @Param("type") String type, @Param("dueBy") String dueBy, @Param("finishedBy") String finishedBy, @Param("status") String status) throws Exception {
        LianzhengUserEntity user=getUser();

        status = (status == null || status.length()<=0) ? "0" : status;
        List<LianzhengUndoEntity> list=this.lzUndoService.queryList(lianzhengReferenceId, type, dueBy, finishedBy, status);
        return R.ok().put("page",list);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete")
    @ResponseBody
    public R deleteLianzhengDongtai(@Param("id") String id) throws Exception {
        LianzhengUserEntity user=getUser();

        this.lzUndoService.deleteLianzhengUndoEntity(id);
        return R.ok();
    }
}
