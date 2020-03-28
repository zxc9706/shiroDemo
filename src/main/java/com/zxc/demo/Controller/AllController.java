package com.zxc.demo.Controller;

import com.zxc.demo.Service.AllService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public String add(@RequestBody Map map){
        String add = allService.add(map);
        return add;
    }

    @PostMapping("getMemos")
    public ResponseEntity getMemos(@RequestBody Map map){
        List<Map> memos = allService.getMemos(map);
        return ResponseEntity.ok().body(memos);
    }

    @PostMapping("delMemo")
    public ResponseEntity delMemo(@RequestBody Map map){
        String memos = allService.delMemo(map);
        return ResponseEntity.ok().body(memos);
    }

    @PostMapping("editMemo")
    public ResponseEntity editMemo(@RequestBody Map map){
        String memos = allService.editMemo(map);
        return ResponseEntity.ok().body(memos);
    }

}
