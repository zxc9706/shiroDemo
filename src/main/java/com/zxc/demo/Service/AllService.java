package com.zxc.demo.Service;

import com.zxc.demo.mapper.AllMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AllService {

    @Autowired
    private AllMapper allMapper;

    public List<Map> getTab(){
        List<Map> tab = allMapper.getTab();
        return tab;
    }

}
