package com.demo.zptst.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.demo.zptst.entity.User;

public interface UserDao {
	
    /**
     * 查询用户总数
     *
     * @param param
     * @return
     */
    int getTotalUser(Map param);
    
    /**
     * 查询粉丝总数
     *
     * @param id 用户ID
     * @return
     */
    int getTotalFollower(Map param);
    
    /**
     * 根据参数查询用户
     *
     * @param param
     * @return
     */
    List<User> getUsers(Map param);
    
    /**
     * 根据用户ID查询粉丝用户
     *
     * @param param
     * @return
     */
    List<User> getFollowers(Map param);
    
    /**
     * 根据id获取用户记录
     *
     * @return
     */
    User getUserById(Long id);

    /**
     * 根据用户名获取用户记录
     *
     * @return
     */
    User getUserByName(String userName);

    /**
     * 新增用户记录
     *
     * @return
     */
    int createUser(User user);

    /**
     * 更新用户信息
     *
     * @return
     */
    int updateUser(User user);

  
    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteBatch(Object[] ids);

}
