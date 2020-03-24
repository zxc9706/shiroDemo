package com.zxc.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zxc.demo.Model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据账户查询用户信息
     * @param username
     * @return
     */
    User findByUsername(@Param("username") String username);

    Map getUserInfo(@Param("username")String username,@Param("password")String password,@Param("salt")String salt);

}
