package com.yugao.lianzheng.modules.sys.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    public String userId;
    public String userName;
    public String deptId;
    public String deptName;
    public String userFace;
}
