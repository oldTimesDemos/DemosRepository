package com.qfedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.entity.SysRole;
import com.qfedu.service.SysRoleService;
import com.qfedu.vo.JsonBean;

@Controller
@ResponseBody
public class RoleController {

	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("/role/list.do")
	public JsonBean findAllRoles() {
		List<SysRole> list = sysRoleService.findAllRoles();
		
		return new JsonBean(1, list);
	}
	
	@RequestMapping("/role/roleList.do")
	public JsonBean findAllSysroles() {
		List<SysRole> list = sysRoleService.findAllSysRoles();
		return new JsonBean(1, list);
	}
	
	@RequestMapping("/role/deleteByRid.do")
	public JsonBean deleteRoleByRid(int roleId) {
		
		sysRoleService.deleteRoleByRid(roleId);
		
		return new JsonBean(1, null);
	}
	
	@RequestMapping("/role/addRole.do")
	public JsonBean addRole(SysRole role) {
		role.setRoleFlag(1);
		sysRoleService.addRole(role);
		return new JsonBean(1, null);
	}
	
	@RequestMapping("/role/findByRoleId.do")
	public JsonBean findByRoleId(int roleId) {
		SysRole role = sysRoleService.findByRoleId(roleId);
		return new JsonBean(1, role);
	}
	
	@RequestMapping("/role/updateRole.do")
	public JsonBean updateRole(SysRole role) {
		sysRoleService.updateRole(role);
		return new JsonBean(1, null);
	}
}
