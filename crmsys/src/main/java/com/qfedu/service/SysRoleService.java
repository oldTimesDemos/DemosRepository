package com.qfedu.service;

import java.util.List;

import com.qfedu.entity.SysRole;

public interface SysRoleService {

	public List<SysRole> findAllRoles();
	
	/**
	 * 	查看所有的角色
	 * @return
	 */
	public List<SysRole> findAllSysRoles();
	
	/**
	 * 	根据roleId删除角色
	 * @param roleId
	 */
	public void deleteRoleByRid(int roleId);
	
	/**
	 * 	添加角色
	 * @param role
	 */
	public void addRole(SysRole role);
	
	/**
	 * 	根据roleId查看信息
	 * @param roleId
	 * @return
	 */
	public SysRole findByRoleId(int roleId);
	
	/**
	 * 	更新角色信息
	 * @param role
	 */
	public void updateRole(SysRole role);
}
