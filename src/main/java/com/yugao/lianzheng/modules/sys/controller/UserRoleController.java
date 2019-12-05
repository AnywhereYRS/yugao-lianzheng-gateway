package com.yugao.lianzheng.modules.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.qiniu.util.Md5;
import com.yugao.lianzheng.common.utils.DateUtils;
import com.yugao.lianzheng.common.utils.PageBar;
import com.yugao.lianzheng.common.utils.R;
import com.yugao.lianzheng.modules.sys.entity.LianzhengUserEntity;

import com.yugao.lianzheng.modules.sys.entity.LianzhengUserRoleEntity;
import com.yugao.lianzheng.modules.sys.model.UserStatusCode;
import com.yugao.lianzheng.modules.sys.service.LianzhengUserRoleService;
import com.yugao.lianzheng.modules.sys.service.LianzhengUserService;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserRoleController extends AbstractController{

    @Autowired
    private LianzhengUserService lianzhengUserService;

    @Autowired
    private LianzhengUserRoleService lianzhengUserRoleService;

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    @ResponseBody
    public R updateNote(@RequestBody LianzhengUserEntity entity) throws Exception {
        logger.debug("上传的参数信息--->"+entity.toString());
        LianzhengUserEntity user=getUser();

        // 新增用户
        if(StringUtils.isBlank(entity.getUserId())){
            LianzhengUserEntity exist = lianzhengUserService.getDetailByUserName(entity.getUsername());
            if (ObjectUtils.isNotEmpty(exist)) {
                return R.error("用户已存在！");
            }
            String id = IdWorker.getIdStr();
            entity.setUserId(id);
            String salt = RandomStringUtils.randomAlphanumeric(20);
            entity.setPassword(new Sha256Hash("000000", salt).toHex()); //设置初始密码 000000
            entity.setSalt(salt);
            entity.setStatus(UserStatusCode.NORMAL_USER.getCode());
            entity.setCreateTime(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
            entity.setUpdateTime(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
            lianzhengUserService.save(entity);
            for (LianzhengUserRoleEntity roleEntity : entity.getRoleEntityList()) {
                roleEntity.setUserId(id);
                roleEntity.setUserName(entity.getUsername());
                lianzhengUserRoleService.save(roleEntity);
            }
            return R.ok().put("data", entity);
        }
        //更新用户
        else{
            LianzhengUserEntity exist = lianzhengUserService.getDetailByUserId(String.valueOf(entity.getUserId()));
            if (ObjectUtils.isEmpty(exist)) {
                return R.error("用户不存在！");
            }
            entity.setUpdateTime(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
            lianzhengUserService.updateUser(entity);
            if (entity.getRoleEntityList().size() > 0) {
                lianzhengUserRoleService.deleteUserRole(String.valueOf(entity.getUserId()),null);

                for (LianzhengUserRoleEntity roleEntity : entity.getRoleEntityList()) {
                    roleEntity.setUserId(String.valueOf(entity.getUserId()));
                    roleEntity.setUserName(entity.getUsername());
                    lianzhengUserRoleService.save(roleEntity);
                }
            }
            return R.ok().put("data",entity);
        }
    }


    @RequestMapping(method = RequestMethod.GET, path = "/detail")
    @ResponseBody
    public R queryByID(@Param("userId") String userId) {
        LianzhengUserEntity user=getUser();
        LianzhengUserEntity entity=lianzhengUserService.getDetailByUserId(userId);
        entity.setRoleEntityList(lianzhengUserRoleService.queryListUserRole(userId,null));
        return R.ok().put("data",entity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    @ResponseBody
    public R queryList(@Param("status") String status,
                       @Param("page") int page,
                       @Param("size") int size) throws Exception {
        LianzhengUserEntity user=getUser();

        page =  page >1 ? page : 1;
        size =  size >0 ? size : 20;
        int toIndexNum = (page -1) * size;
        List<LianzhengUserEntity> list=lianzhengUserService.queryList(status,toIndexNum,size);

        for (LianzhengUserEntity entity : list) {
            entity.setRoleEntityList(lianzhengUserRoleService.queryListUserRole(String.valueOf(entity.getUserId()),null));
        }
        PageBar pagebar = new PageBar();
        pagebar.setPage(page);
        pagebar.setSize(size);
        pagebar.setTotal(lianzhengUserService.queryListCount(status));
        return R.ok().put("list",list).put("pagebar",pagebar);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/disable")
    @ResponseBody
    public R disableLianzhengUser(@Param("userId") String userId) throws Exception {
        LianzhengUserEntity user=getUser();
        LianzhengUserEntity entity = new LianzhengUserEntity();
        entity.setUserId(userId);
        entity.setStatus(UserStatusCode.DISABLE_USER.getCode());
        lianzhengUserService.updateUser(entity);
        lianzhengUserRoleService.deleteUserRole(userId,null);
        return R.ok();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/enable")
    @ResponseBody
    public R enableLianzhengUser(@Param("userId") String userId) throws Exception {
        LianzhengUserEntity user=getUser();
        LianzhengUserEntity entity = new LianzhengUserEntity();
        entity.setUserId(userId);
        entity.setStatus(UserStatusCode.NORMAL_USER.getCode());
        lianzhengUserService.updateUser(entity);
        lianzhengUserRoleService.deleteUserRole(userId,null);
        return R.ok();
    }
}
