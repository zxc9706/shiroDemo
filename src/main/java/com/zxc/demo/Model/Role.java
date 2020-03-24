package com.zxc.demo.Model;

import lombok.Data;

@Data
public class Role {

    //id
    private Integer id;

    //角色名称
    private String role;

    //角色描述
    private String description;

    //父节点
    private Integer pid;

    //是否锁定
    private Integer available;

}
