package com.zxc.demo.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zxc.demo.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class loginService {

    @Autowired
    private UserMapper userMapper;

    public String login(String username,String password){
        String result = null;
        List list = userMapper.selectList(new EntityWrapper().eq("username", username).eq("locked", 0));
        if (list.size()>0){

        }else {
            result = "用户不存在或者密码错误，请核对后登录!";
        }

        return result;
    }

}
