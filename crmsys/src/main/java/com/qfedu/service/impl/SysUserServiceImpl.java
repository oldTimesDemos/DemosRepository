package com.qfedu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SysUserMapper;
import com.qfedu.entity.SysUser;
import com.qfedu.service.SysUserService;
import com.qfedu.vo.UserInfo;
import com.qfedu.vo.VUserInfo;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper userDao;
	
	@Override
	public SysUser login(String name, String password) {
		
		SysUser user = userDao.selectByName(name);
		if (user == null) {
			throw new RuntimeException("用户名错误");
		}
		
		if (!user.getUsrPassword().equals(password)) {
			throw new RuntimeException("密码错误");
		}
		return user;
	}

	@Override
	public UserInfo findUserInfoByUid(Integer uid) {
		return userDao.selectInfoByUid(uid);
	}

	@Override
	public Map<String, Object> findUsersByPage(int page) {
		//	分页插件，第一个参数 页码 第二个参数 每页显示记录个数
		PageHelper.startPage(page, 5);
		List<VUserInfo> list = userDao.selectAll();
		
		Map<String, Object> map = new HashMap<>();
		//	显示行数
		map.put("total", ((Page)list).getTotal());
		//	当前页显示的记录
		map.put("rows", list);
		return map;
	}

	@Override
	public void addUser(SysUser user) {

		userDao.insertSelective(user);
	}

	@Override
	public void deleteUserByUid(int uid) {

		SysUser user = userDao.selectByPrimaryKey(uid);
		
		if (user == null) {
			throw new RuntimeException("该用户不存在");
		}
		
		if (user.getUsrFlag()==0) {
			throw new RuntimeException("该用户已删除");
		}
		user.setUsrFlag(0);
		userDao.updateByPrimaryKey(user);
	}

	@Override
	public VUserInfo findUserByUid(int usrId) {
		VUserInfo userInfo = userDao.selectUserByUid(usrId);
		if (userInfo == null) {
			throw new RuntimeException("该用户不存在");
		}
		return userInfo;
	}

	@Override
	public void updateUserInfo(SysUser user) {

		userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public void importUserInfo(List<SysUser> users) {

		userDao.insertUsers(users);
	}

	@Override
	public Map<String, Object> findUsersBycons(int page, String usrName, int roleId) {
		
		PageHelper.startPage(page, 5);
		List<VUserInfo> list = userDao.selectUserByNameOrRoleId(usrName, roleId);
		
		if (list == null || list.isEmpty()) {
			throw new RuntimeException("未查询到相关数据");
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", ((Page)list).getTotal());
		map.put("rows", list);
		return map;
	}

	
}
