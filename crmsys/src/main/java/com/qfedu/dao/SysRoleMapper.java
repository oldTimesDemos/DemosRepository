package com.qfedu.dao;

import java.util.List;

import com.qfedu.entity.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    /**
     * 	查看所有未删除的角色
     * @return
     */
    public List<SysRole> selectAll();
    
    /**
     * 	查看所有的角色
     * @return
     */
    public List<SysRole> selectAllRoles();
    
    /**
     * 	根据角色名查询角色
     * @param roleName
     * @return
     */
    public SysRole findRoleByRoleName(String roleName);
    
	}
