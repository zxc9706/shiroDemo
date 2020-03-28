package com.zxc.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zxc.demo.Model.All;

import java.util.List;
import java.util.Map;

public interface AllMapper extends BaseMapper<All> {

    List<Map> getTab();

    Integer add(Map map);
}
