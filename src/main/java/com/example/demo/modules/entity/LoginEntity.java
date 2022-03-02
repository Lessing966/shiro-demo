package com.example.demo.modules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_login")
public class LoginEntity {
    private Integer id;

    private String username;

    private String loginname;

    private String password;

    private String fId;

    private String gId;

    private Integer status;

    private String createTime;

    private String updateTime;

    @TableField(exist = false)
    private String fname;

    @TableField(exist = false)
    private String gname;

    private String ip;

    @TableField(exist = false)
    private int pageNumber;

    @TableField(exist = false)
    private int pageSize;

}
