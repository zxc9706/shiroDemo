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

    public String add(Map map){
        String result = null;
        Integer add = allMapper.add(map);
        if (add < 1){
            result = "添加失败";
        }else {
            result = "添加成功";
        }
        return result;
    }

    public List<Map> getMemos(Map map) {

        List<Map> memos = allMapper.getMemos(map);
        return memos;

    }

    public String delMemo(Map map) {
        String result = null;
        Integer integer = allMapper.delMemo(map);
        if (integer<1){
            result = "删除失败";
        }else {
            result = "删除成功";
        }
        return result;
    }

    public String editMemo(Map map) {
        String result = null;
        Integer integer = allMapper.editMemo(map);
        if (integer<1){
            result = "修改失败";
        }else {
            result = "修改成功";
        }
        return result;
    }
}
