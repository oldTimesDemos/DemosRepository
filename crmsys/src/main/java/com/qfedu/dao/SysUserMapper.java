package com.qfedu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qfedu.entity.SysUser;
import com.qfedu.vo.UserInfo;
import com.qfedu.vo.VUserInfo;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer usrId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer usrId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    ////////////////////////////////////
    /**
     * 	根据用户名查询
     * @param name
     * @return
     */
    SysUser selectByName(String name);
    /**
     * 	根据uid查询用户信息
     * @param uid
     * @return
     */
    UserInfo selectInfoByUid(Integer uid);
    
    /**
     * 	查看所有user信息
     * @return
     */
    List<VUserInfo> selectAll();
    
    /**
     * 	根据uid查询用户信息
     * @param uid
     * @return
     */
    VUserInfo selectUserByUid(int uid);
    
    /**
     * 	添加多个用户数据
     * @param users
     */
    public void insertUsers(List<SysUser> users);
    
    /**
     * 	根据姓名或者角色id进行模糊查询
     * @param usrName
     * @param roleId
     * @return
     */
    List<VUserInfo> selectUserByNameOrRoleId(@Param("usrName") String usrName,@Param("roleId") int roleId);
}