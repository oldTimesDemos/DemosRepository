package com.qfedu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SysRightMapper;
import com.qfedu.entity.SysRight;
import com.qfedu.service.SysRightService;
import com.qfedu.vo.VMenuInfo;
import com.qfedu.vo.VRight;
import com.qfedu.vo.VTreeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRightServiceImpl implements SysRightService {

	@Autowired
	private SysRightMapper rightDao;
	
	@Override
	public List<VMenuInfo> findMenue(int roleId) {
		return rightDao.selectMenu(roleId);
	}

	@Override
	public List<VTreeInfo> findTreeNode(int roleId) {
		
		List<VTreeInfo> list = rightDao.selectAllTreeNode();
		List<Integer> cList = rightDao.selectCheckNodeId(roleId);
		if (cList != null) {
			for (VTreeInfo	 info : list) {
				if (cList.contains(info.getRightCode())) {
					info.setChecked(true);
				}
			}
		}
		return list;
	}

	@Override
	public void changeRightInfo(Integer roleId, Integer[] rightCodes) {
		//	先删除原来给予的权限信息
		rightDao.deleteByRoleId(roleId);
		//	插入新的权限信息
		rightDao.insertRoleAndRight(roleId, rightCodes);
	}

	@Override
	public Map<String, Object> findAllRights(int page) {
	
		PageHelper.startPage(page, 5);
		List<VRight> list = rightDao.findAllRighs();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("row", list);
		map.put("total", ((Page)list).getTotal());
		
		return map;
	}

	@Override
	public void updateRight(SysRight right) {

		int code = right.getRightCode();

		SysRight right1 = rightDao.selectByPrimaryKey(code);

		if (right == null) {
			throw  new  RuntimeException("未查找到有效数据");
		}

		rightDao.updateByPrimaryKeySelective(right);
	}

	@Override
	public List<SysRight> findAllParentNode() {
		List<SysRight> list = rightDao.findAllParentNode();
		return  list;
	}

	@Override
	public Map<String, Object> findRightsByCondition(int page, String rightName, int rightParentCode) {

		PageHelper.startPage(page,5);
		List<VRight> list = rightDao.seachByCondition(rightName, rightParentCode);

		Map<String, Object> map = new HashMap<>();
		map.put("rows",list);
		map.put("total",((Page)list).getTotal());
		return map;
	}

	@Override
	public SysRight findRightByRightCode(int rightCode) {
		return rightDao.selectByPrimaryKey(rightCode);
	}

	@Override
	public void updateRightInfo(SysRight right) {
		rightDao.updateByPrimaryKeySelective(right);
	}
}
