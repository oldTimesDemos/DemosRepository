package com.qfedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qfedu.dao.SysRoleMapper;
import com.qfedu.entity.SysRole;
import com.qfedu.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleMapper sysRoleDao;
	
	@Override
	public List<SysRole> findAllRoles() {
		return sysRoleDao.selectAll();
	}

	@Override
	public List<SysRole> findAllSysRoles() {
		return sysRoleDao.selectAllRoles();
	}

	@Override
	public void deleteRoleByRid(int roleId) {

		SysRole sysRole = sysRoleDao.selectByPrimaryKey(roleId);
		
		if (sysRole == null) {
			throw new RuntimeException("该角色不存在");
		}
		
		if (sysRole.getRoleFlag() == 0) {
			throw new RuntimeException("该角色已是删除状态");
		}
		
		SysRole sysRole2 = new SysRole();
		
		sysRole2.setRoleFlag(0);
		sysRole2.setRoleId(roleId);
		
		sysRoleDao.updateByPrimaryKeySelective(sysRole2);
	}

	@Override
	public void addRole(SysRole role) {

		String roleName = role.getRoleName();
		if (roleName == null || roleName.isEmpty()) {
			throw new RuntimeException("非法字符");
		}
		//	查询当前角色是否已存在
		SysRole role2 = sysRoleDao.findRoleByRoleName(roleName);
		
		if (role2 != null) {
			throw new RuntimeException("该角色已存在");
		}
		
		sysRoleDao.insert(role);
		
	}

	@Override
	public SysRole findByRoleId(int roleId) {
		
		SysRole sysRole = sysRoleDao.selectByPrimaryKey(roleId);
		return sysRole;
	}

	@Override
	public void updateRole(SysRole role) {

		sysRoleDao.updateByPrimaryKeySelective(role);
	}

}
