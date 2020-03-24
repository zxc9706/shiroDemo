package com.zxc.demo.Service;

import com.zxc.demo.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 根据角色id查询权限
     * @param roleIds
     * @return
     */
    public List<String> findByRoleId(List<Integer> roleIds) {
        return permissionMapper.findByRoleId(roleIds);
    }

}
