package com.qfedu.vo;
/**
 * 	提供一个包含userId，UserName，userRole的实体类
 * @author daihaoyu
 *
 */
public class UserInfo {

	private Integer usrId;
	private String usrName;
	private String roleName;
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
