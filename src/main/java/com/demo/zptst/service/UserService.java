package com.demo.zptst.service;

import com.demo.zptst.entity.User;
import com.demo.zptst.common.PageResult;
import com.demo.zptst.utils.PageUtil;

public interface UserService {

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
    PageResult getUsers(PageUtil pageUtil);
    
    /**
	 * 根据用户ID查询粉丝用户
	 * 
	 * @return
	 */
    PageResult getFollowers(PageUtil pageUtil);

    /**
     * 根据id获取用户
     *
     * @return
     */
    User selectById(Long id);

    /**
     * 根据用户名获取用户
     *
     * @return
     */
    User getByUserName(String userName);

    /**
     * 新增用户
     *
     * @return
     */
    int create(User user);

    /**
     * 更新用户
     *
     * @return
     */
    int updateUser(User user);

    /**
     * 删除/批量删除功能
     *
     * @param ids
     * @return
     */
    int deleteUsers(Integer[] ids);
}
