package com.yuansheng.resultful.mapper;

import java.util.List;

import com.yuansheng.resultful.domain.User;

public interface UserDao {
	public List<User> listUser();

	public void addUser(String name, Integer sex);

	public void deleteUserById(Integer id);

	public void updateUserById(User user);
}
