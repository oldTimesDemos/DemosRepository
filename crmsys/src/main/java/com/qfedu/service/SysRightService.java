package com.qfedu.service;

import java.util.List;
import java.util.Map;

import com.qfedu.vo.VMenuInfo;
import com.qfedu.vo.VRight;
import com.qfedu.vo.VTreeInfo;

public interface SysRightService {
	
	/**
	 * 	获取菜单项
	 * @param roleId
	 * @return
	 */
	public List<VMenuInfo> findMenue(int roleId);
	
	/**
	 * 	获取节点数据
	 * @param roleId
	 * @return
	 */
	public List<VTreeInfo> findTreeNode(int roleId);
	
	/**
	 * 	修改权限信息
	 */
	public void changeRightInfo(Integer roleId, Integer[] rightCodes);
	
	/**
	 * 	获取所有权限的描述
	 * @return
	 */
	public Map<String, Object> findAllRights(int page);
}
