package com.demo.zptst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.zptst.common.PageResult;
import com.demo.zptst.entity.User;
import com.demo.zptst.service.UserService;
import com.demo.zptst.utils.PageUtil;
import com.demo.zptst.dao.UserDao;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao UserDao;
	
	@Override
	public PageResult getUsers(PageUtil pageUtil) {
		//当前页码中的数据列表
        List<User> users = UserDao.getUsers(pageUtil);
        //数据总条数 用于计算分页
        int total =UserDao.getTotalUser(pageUtil);
        PageResult pageResult = new PageResult(users, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
	}

	@Override
	public User selectById(Long id) {
		return UserDao.getUserById(id);
	}

	@Override
	public User getByUserName(String userName) {
		return UserDao.getUserByName(userName);
	}

	@Override
	public int create(User user) {
		return UserDao.createUser(user);
	}

	@Override
	public int updateUser(User user) {
		return UserDao.updateUser(user);
	}

	@Override
	public int deleteUsers(Integer[] ids) {
		return UserDao.deleteBatch(ids);
	}

	@Override
	public PageResult getFollowers(PageUtil pageUtil) {
		//当前页码中的数据列表
        List<User> users = UserDao.getFollowers(pageUtil);
        //数据总条数 用于计算分页
        int total =UserDao.getTotalFollower(pageUtil);
        PageResult pageResult = new PageResult(users, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
	}

}
