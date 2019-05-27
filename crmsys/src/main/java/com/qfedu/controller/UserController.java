package com.qfedu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.entity.SysUser;
import com.qfedu.service.SysUserService;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.VUserInfo;
@Controller
@ResponseBody
public class UserController {

	@Autowired
	private SysUserService userService;
	
	@RequestMapping("/user/list.do")
	public JsonBean findUserByPage(int page) {
		Map<String, Object> map = userService.findUsersByPage(page);
		return new JsonBean(1, map);
	}
	
	@RequestMapping("/user/add.do")
	public JsonBean addUser(SysUser user) {
		if (user.getUsrName() == null || user.getUsrName().isEmpty()) {
			return new JsonBean(0, "请输入姓名");
		}
		if (user.getUsrPassword() == null || user.getUsrPassword().isEmpty()) {
			return new JsonBean(0, "请输入密码");
		}
		user.setUsrFlag(1);
		userService.addUser(user);
		return new JsonBean(1, null);
	}
	
	@RequestMapping("/user/delete.do")
	public JsonBean deleteUser(int uid) {
		userService.deleteUserByUid(uid);
		return new JsonBean(1, "删除成功");
	}
	
	@RequestMapping("/user/findById.do")
	public JsonBean findUserByUid(int uid) {
		VUserInfo userInfo = userService.findUserByUid(uid);
		
		return new JsonBean(1, userInfo);
	}
	
	@RequestMapping("/user/update.do")
	public JsonBean updateUser(SysUser user) {
		userService.updateUserInfo(user);
		
		return new JsonBean(1, null);
	}
	
	@RequestMapping("/user/search.do")
	public JsonBean findUserByCon(int page, String usrName, int roleId) {
		
		Map<String, Object> map = userService.findUsersBycons(page, usrName, roleId);
		
		return new JsonBean(1, map);
	}
}
