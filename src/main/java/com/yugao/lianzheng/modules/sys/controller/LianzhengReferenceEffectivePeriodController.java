package com.yugao.lianzheng.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEffectivePeriodEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReferenceEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceEffectivePeriodService;
import com.yugao.lianzheng.modules.sys.service.LianzhengReferenceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 廉政公告涵时间限制
 */
@RestController
@RequestMapping("/referenceEffPeriod")
@Slf4j
public class LianzhengReferenceEffectivePeriodController extends AbstractController{

    @Autowired(required = false)
    private LianzhengReferenceEffectivePeriodService lzReferenceEffectivePeriodService;

    @RequestMapping(method = RequestMethod.POST, path = "/addOrUpdate")
    @ResponseBody
    public R updateReference(@RequestBody LianzhengReferenceEffectivePeriodEntity entity) throws Exception {
        logger.debug("上传的参数信息--->"+entity.toString());
        LianzhengUserEntity user=getUser();

        // 新增廉政动态
        if(StringUtils.isBlank(entity.getLianzhengReferenceEffectivePeriodId())){
            String id = IdWorker.getIdStr();
            entity.setLianzhengReferenceId(id);
            entity.setStatus(1);
            this.lzReferenceEffectivePeriodService.save(entity);
            return R.ok().put("data", entity);
        }
        //更新廉政动态
        else{
            this.lzReferenceEffectivePeriodService.updateLianzhengReferenceEffectivePeriod(entity);
            return R.ok().put("data",entity);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/find")
    @ResponseBody
    public R query(@Param("referenceId") String referenceId) {
        LianzhengUserEntity user=getUser();
        LianzhengReferenceEffectivePeriodEntity entity=this.lzReferenceEffectivePeriodService.getLianzhengReferenceEffectivePeriod(referenceId);
        return R.ok().put("data",entity);
    }
}
