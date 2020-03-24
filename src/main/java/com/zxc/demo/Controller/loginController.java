package com.zxc.demo.Controller;

import com.zxc.demo.Model.User;
import com.zxc.demo.Service.loginService;
import com.zxc.demo.Utils.ResponseCode;
import com.zxc.demo.Utils.StatusEnmus;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.apache.shiro.SecurityUtils.getSubject;

@RestController
public class loginController {

    @Autowired
    loginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseCode login(@RequestBody User user) {
        Subject userSubject = getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            // 登录验证
            userSubject.login(token);
            Map map = new HashMap();
            //登录成功
            map.put("token",userSubject.getSession().getId());
            return new ResponseCode(ResponseCode.success().getCode(),ResponseCode.success().getMessage(),map);
        } catch (UnknownAccountException e) {
            //账户不存在
            return ResponseCode.error(StatusEnmus.ACCOUNT_UNKNOWN);
        } catch (DisabledAccountException e) {
            //账号被禁用
            return ResponseCode.error(StatusEnmus.ACCOUNT_IS_DISABLED);
        } catch (IncorrectCredentialsException e) {
            //用户名或密码错误
            return ResponseCode.error(StatusEnmus.INCORRECT_CREDENTIALS);
        } catch (Throwable e) {
            e.printStackTrace();
            //系统错误
            return ResponseCode.error(StatusEnmus.SYSTEM_ERROR);
        }
    }

    @GetMapping("/login")
    public ResponseCode login() {
        return ResponseCode.error(StatusEnmus.NOT_LOGIN_IN);
    }

    @GetMapping("/auth")
    public String auth() {
        return "已成功登录";
    }

    @GetMapping("/role")
    @RequiresRoles("vip")
    public String role() {
        return "测试Vip角色";
    }

    @GetMapping("/permission")
    @RequiresPermissions(value = {"add", "update"}, logical = Logical.AND)
    public String permission() {
        return "测试Add和Update权限";
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    public ResponseCode logout() {
        getSubject().logout();
        return ResponseCode.success();
    }

}
