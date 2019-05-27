package com.qfedu.service;

import java.util.List;
import java.util.Map;

import com.qfedu.entity.SysUser;
import com.qfedu.vo.UserInfo;
import com.qfedu.vo.VUserInfo;

public interface SysUserService {
	
	/**
	 * 	登陆操作
	 * @param name
	 * @param password
	 * @return
	 */
	public SysUser login(String name, String password);
	
	/**
	 * 	根据uid查找用户的详细信息
	 * @param uid
	 * @return
	 */
	public UserInfo findUserInfoByUid(Integer uid);
	
	/**
	 * 	查询所有的用户信息
	 * @return
	 */
	public Map<String, Object> findUsersByPage(int page);
	
	/**
	 * 	添加用户
	 * @param user
	 */
	public void addUser(SysUser user);
	
	/**
	 * 	根据uid删除user
	 * @param uid
	 */
	public void deleteUserByUid(int uid);
	
	/**
	 * 	根据usrId查询用户信息
	 * @param usrId
	 */
	public VUserInfo findUserByUid(int usrId);
	
	/**
	 * 	更新用户信息
	 * @param user
	 */
	public void updateUserInfo(SysUser user);
	
	/**
	 * 	批量添加用户
	 * @param users
	 */
	public void importUserInfo(List<SysUser> users);
	
	/**
	 * 	模糊查询用户
	 * @param page 
	 * @param usrName
	 * @param roleId
	 * @return
	 */
	public Map<String, Object> findUsersBycons(int page, String usrName, int roleId);
}
