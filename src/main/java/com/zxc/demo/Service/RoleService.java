package com.zxc.demo.Service;

import com.zxc.demo.Model.Role;
import com.zxc.demo.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 根据userId查询角色信息
     * @param id
     * @return
     */
    public List<Role> findRoleById(Integer id) {
        return roleMapper.findRoleById(id);
    }

}
