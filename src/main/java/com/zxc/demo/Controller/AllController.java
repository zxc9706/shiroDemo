package com.zxc.demo.Controller;

import com.zxc.demo.Service.AllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController

public class AllController {

    @Autowired
    private AllService allService;

    /**
     * 获取微信小程序底部bar
     * @return
     */
    @GetMapping("getTab")
    public ResponseEntity getTab(){
        List<Map> tab = allService.getTab();
        return ResponseEntity.ok().body(tab);
    }

}
