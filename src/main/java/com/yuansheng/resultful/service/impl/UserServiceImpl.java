package com.yuansheng.resultful.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuansheng.resultful.domain.User;
import com.yuansheng.resultful.mapper.UserDao;
import com.yuansheng.resultful.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
@Autowired
private UserDao entityDao;
	@Override
	public List<User> listUser() {
		return entityDao.listUser();
	}

	@Override
	public void addUser(String name, Integer sex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserById(User user) {
		// TODO Auto-generated method stub

	}

}
