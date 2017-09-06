package com.yuansheng.resultful.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuansheng.resultful.domain.User;

public interface UserDao {
	public List<User> listUser();

	public void deleteUserById(Integer id);

	public void updateUserById(User user);

	public void insertUser(@Param(value = "name") String name, @Param(value = "sex") Integer sex);

	public User findUserById(@Param(value = "userId") Integer userId);
}
