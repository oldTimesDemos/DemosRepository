package com.qfedu.controller;

import com.qfedu.common.CommonInfo;
import com.qfedu.entity.SysRight;
import com.qfedu.entity.SysUser;
import com.qfedu.service.SysRightService;
import com.qfedu.vo.JsonBean;
import com.qfedu.vo.VTreeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class RightController {

	@Autowired
	private SysRightService rightService;
	
	@RequestMapping("/right/tree.do")
	public JsonBean findTreeNodes(int roleId) {
		List<VTreeInfo> list = rightService.findTreeNode(roleId);
		
		return new JsonBean(1, list);
	}
	
	@RequestMapping("/right/update.do")
	public JsonBean updateRights(Integer roleId, Integer[] rightCodes,HttpSession session) {
		//	执行修改
		rightService.changeRightInfo(roleId, rightCodes);
		
		SysUser user = (SysUser) session.getAttribute(CommonInfo.LOGIN_USER);
		
		if (roleId == user.getUsrRoleId()) {
			return new JsonBean(2, null);
		}else {
			return new JsonBean(1, null);
		}
	}
	
	@RequestMapping("/right/rightList.do")
	public JsonBean findAllRights(int page) {
		Map<String, Object> map = rightService.findAllRights(page);
		return new JsonBean(1, map);
	}

	@RequestMapping("/right/delRight.do")
	public  JsonBean deleteRight(int rightCode){
		SysRight right = new SysRight();
		right.setRightCode(rightCode);
		right.setRightFlag(0);

		rightService.updateRight(right);

		return new JsonBean(1,"null");
	}
	@RequestMapping("/right/allNode.do")
	public JsonBean findAllNode(){
		List<SysRight> list = rightService.findAllParentNode();

		return new JsonBean(1,list);
	}

	@RequestMapping("/right/findByCon.do")
	public JsonBean findByCondition(int page, String rightName,int rightParentCode){
		Map<String, Object> map = rightService.findRightsByCondition(page, rightName, rightParentCode);

		return  new JsonBean(1,map);
	}

	@RequestMapping("/right/findInfoByRightCode.do")
	public  JsonBean findInfoByRightCode(int rightCode){

		SysRight right = rightService.findRightByRightCode(rightCode);

		return new JsonBean(1,right);
	}

	@RequestMapping("/right/updateInfo.do")
	public  JsonBean updateRight(SysRight right){
		rightService.updateRight(right);

		return new JsonBean(1,null);
	}
}
