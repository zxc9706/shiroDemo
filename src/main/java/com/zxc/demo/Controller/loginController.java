package com.zxc.demo.Controller;

import com.zxc.demo.Service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class loginController {

    @Autowired
    loginService loginService;

    @RequestMapping("/test")
    public String login (@RequestParam String username,@RequestParam String password){
        String login = loginService.login(username, password);
        return login;
    }

}
