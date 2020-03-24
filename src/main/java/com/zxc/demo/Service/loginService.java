package com.zxc.demo.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zxc.demo.mapper.UserMapper;
import com.zxc.demo.Model.User;
import com.zxc.demo.Utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class loginService {

    @Autowired
    private UserMapper userMapper;

    public String login(String username,String password){
        String result = null;
        Map userInfo = userMapper.getUserInfo(username, password, SecurityUtils.toMD5(password));
        if (userInfo==null){
            result = "账户不存在或密码错误！";
        }else {
            result = "登陆成功！";
        }
        return result;
    }

}
