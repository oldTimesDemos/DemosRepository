package com.qfedu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qfedu.common.CommonInfo;
import com.qfedu.entity.SysUser;
import com.qfedu.service.SysRightService;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.VMenuInfo;

@Controller
@ResponseBody
public class MenuController {

	@Autowired
	private SysRightService rightService;
	
	@RequestMapping("/menu.do")
	public JsonBean findMenue(HttpSession session) {
		SysUser user = (SysUser) session.getAttribute(CommonInfo.LOGIN_USER);
		
		if (user == null) {
			return new JsonBean(0, "请登录");
		}
		
		int roleId = user.getUsrRoleId();
		
		List<VMenuInfo> list = rightService.findMenue(roleId);
		
		return new JsonBean(1, list);
	} 
	
	
}
