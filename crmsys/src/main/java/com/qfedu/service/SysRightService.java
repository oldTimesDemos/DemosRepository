package com.qfedu.service;

import com.qfedu.entity.SysRight;
import com.qfedu.vo.VMenuInfo;
import com.qfedu.vo.VTreeInfo;

import java.util.List;
import java.util.Map;

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

	/**
	 * 	更新right信息
	 * @param right
	 */
	public  void updateRight(SysRight right);

	/**
	 * 查询所有的父节点
	 * @return
	 */
	public  List<SysRight> findAllParentNode();

	/**
	 * 	根据相关信息展示数据
	 * @param page
	 * @param rightName
	 * @param rightParentCode
	 * @return
	 */
	public Map<String,Object> findRightsByCondition(int page, String rightName, int rightParentCode);

	/**
	 * 	根据rightCode查询信息
	 * @param rightCode
	 * @return
	 */
	public SysRight findRightByRightCode(int rightCode);

	/**
	 * 	更新权限信息
	 * @param right
	 */
	public void  updateRightInfo(SysRight right);
}
