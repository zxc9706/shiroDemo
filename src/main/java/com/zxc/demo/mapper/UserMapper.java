package com.zxc.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper extends BaseMapper {

    Map getUserInfo(@Param("username")String username,@Param("password")String password,@Param("salt")String salt);

}
