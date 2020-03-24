package com.zxc.demo.Model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("sys_users")
public class User {

    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String role_id;
    private Integer locked;

}
