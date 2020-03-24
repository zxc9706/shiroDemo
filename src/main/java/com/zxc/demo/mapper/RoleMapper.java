package com.zxc.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zxc.demo.Model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据userId查询角色信息
     * @param id
     * @return
     */
    List<Role> findRoleById(@Param("id") Integer id);

}
