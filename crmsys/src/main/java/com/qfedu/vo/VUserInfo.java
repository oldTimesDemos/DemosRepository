package com.qfedu.vo;

import com.qfedu.entity.SysRole;
/**
 * 	角色信息
 * @author daihaoyu
 *
 */
public class VUserInfo {

	private Integer usrId;
	private String usrName;
	private SysRole role;
	private Integer usrFlag;
	public Integer getUsrId() {
		return usrId;
	}
	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public Integer getUsrFlag() {
		return usrFlag;
	}
	public void setUsrFlag(Integer usrFlag) {
		this.usrFlag = usrFlag;
	}
	
	
}
