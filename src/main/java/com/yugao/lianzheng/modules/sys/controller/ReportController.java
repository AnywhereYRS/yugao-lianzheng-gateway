package com.yugao.lianzheng.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.common.utils.PageBar;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengFileEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengReportEntity;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;
import com.yugao.lianzheng.modules.sys.model.ModuleCode;
import com.yugao.lianzheng.modules.sys.model.ReportCode;
import com.yugao.lianzheng.modules.sys.service.LianzhengFileService;
import com.yugao.lianzheng.modules.sys.service.LianzhengReportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 廉政报告
 */
@RestController
@RequestMapping("/report")
@Slf4j
public class ReportController extends AbstractController{

    @Autowired(required = false)
    private LianzhengReportService lianzhengReportService;

    @Autowired
    private LianzhengFileService lianzhengFileService;

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    @ResponseBody
    public R updateReport(@RequestBody LianzhengReportEntity entity) throws Exception {
        logger.debug("上传的参数信息--->"+entity.toString());
        LianzhengUserEntity user=getUser();

        // 新增廉政报告
        if(StringUtils.isBlank(entity.getReportId())){

            String id = IdWorker.getIdStr();
            entity.setReportId(id);
            entity.setStatusCode(ReportCode.WAIT_PUBLISH.getCode());
            entity.setStatusDesc(ReportCode.WAIT_PUBLISH.getMessage());
            entity.setCreateDate(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
            entity.setUpdateDate(entity.getCreateDate());
            entity.setUpdateUserId(entity.getCreateUserId());
            entity.setUpdateUserName(entity.getCreateUserName());
            this.lianzhengReportService.save(entity);
            if (StringUtils.isNotBlank(entity.getFileId())){
                LianzhengFileEntity fileEntity = new LianzhengFileEntity();
                fileEntity.setLianzhengFileId(entity.getFileId());
                fileEntity.setBusinessId(id);
                fileEntity.setModuleId(String.valueOf(ModuleCode.LIANZHENG_REPOTR.getCode()));
                lianzhengFileService.updateFile(fileEntity);
            }
            return R.ok().put("data", entity);
        }
        //更新廉政报告
        else{
            entity.setStatusCode(ReportCode.WAIT_PUBLISH.getCode());
            entity.setStatusDesc(ReportCode.WAIT_PUBLISH.getMessage());
            entity.setUpdateDate(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
            entity.setUpdateUserId(entity.getCreateUserId());
            entity.setUpdateUserName(entity.getCreateUserName());
            this.lianzhengReportService.updateLianzhengReport(entity);
            return R.ok().put("data",entity);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/detail")
    @ResponseBody
    public R queryByID(@Param("id") long id) {
        LianzhengUserEntity user=getUser();
        LianzhengReportEntity entity=this.lianzhengReportService.getLianzhengReportDetail(id);
        return R.ok().put("data",entity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    @ResponseBody
    public R queryList(@Param("page") int page,
                       @Param("size") int size) throws Exception {
        LianzhengUserEntity user=getUser();
        page =  page >1 ? page : 1;
        size =  size >0 ? size : 20;
        int toIndexNum = (page -1) * size;
        List<LianzhengReportEntity> list=this.lianzhengReportService.getLianzhengReportList(toIndexNum,size);
        for (LianzhengReportEntity entity : list) {
            entity.setCreateDate(entity.getCreateDate().substring(0,10));
        }
        PageBar pagebar = new PageBar();
        pagebar.setPage(page);
        pagebar.setSize(size);
        pagebar.setTotal(lianzhengReportService.getLianzhengReportListCount());
        return R.ok().put("list",list).put("pagebar",pagebar);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/delete")
    @ResponseBody
    public R deleteLianzhengReport(@Param("id") long id) throws Exception {
        LianzhengUserEntity user=getUser();
        LianzhengReportEntity entity = new LianzhengReportEntity();
        entity.setReportId(String.valueOf(id));
        entity.setStatusCode(ReportCode.HAVETO_DELETE.getCode());
        entity.setStatusDesc(ReportCode.HAVETO_DELETE.getMessage());
        this.lianzhengReportService.updateLianzhengReport(entity);
        return R.ok();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/publish")
    @ResponseBody
    public R publishLianzhengReport(@Param("id") long id) throws Exception {
        LianzhengUserEntity user=getUser();
        LianzhengReportEntity entity = new LianzhengReportEntity();
        entity.setReportId(String.valueOf(id));
        entity.setStatusCode(ReportCode.HAVETO_PUBLISH.getCode());
        entity.setStatusDesc(ReportCode.HAVETO_PUBLISH.getMessage());
        this.lianzhengReportService.updateLianzhengReport(entity);
        return R.ok();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/cancel")
    @ResponseBody
    public R cancelLianzhengReport(@Param("id") long id) throws Exception {
        LianzhengUserEntity user=getUser();
        LianzhengReportEntity entity = new LianzhengReportEntity();
        entity.setReportId(String.valueOf(id));
        entity.setStatusCode(ReportCode.WAIT_PUBLISH.getCode());
        entity.setStatusDesc(ReportCode.WAIT_PUBLISH.getMessage());
        this.lianzhengReportService.updateLianzhengReport(entity);
        return R.ok();
    }
}
