package com.qfedu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.common.CommonInfo;
import com.qfedu.entity.SysUser;
import com.qfedu.service.SysUserService;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.UserInfo;

@Controller
@ResponseBody
public class LoginController {

	@Autowired
	private SysUserService userService;
	/**
	 * 	登录功能
	 * @param name
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/login.do")
	public JsonBean login(String name, String password,HttpSession session) {
			SysUser user = userService.login(name, password);
			session.setAttribute(CommonInfo.LOGIN_USER, user);
			return new JsonBean(1, null);
	}
	@RequestMapping("/getUserInfo.do")
	public JsonBean findUserInfo(HttpSession session) {
		SysUser user = (SysUser) session.getAttribute(CommonInfo.LOGIN_USER);
		
		int id = user.getUsrId();
		
		UserInfo info = userService.findUserInfoByUid(id);
		return new JsonBean(1, info);
	}
	
	@RequestMapping("/logout.do")
	public JsonBean logout(HttpSession session) {
		session.removeAttribute(CommonInfo.LOGIN_USER);
		
		return new JsonBean(1, null);
	}
}
