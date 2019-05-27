package com.qfedu.vo;
/**
 * 	如果当成父菜单类
 * @author daihaoyu
 *
 */

import java.util.List;

public class VMenuInfo {

	private Integer menuId;
	private String menuName;
	private String menuUrl;
	//	子菜单列表
	private List<VMenuInfo> menulist;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public List<VMenuInfo> getMenulist() {
		return menulist;
	}
	public void setMenulist(List<VMenuInfo> menulist) {
		this.menulist = menulist;
	}
	
	
}
