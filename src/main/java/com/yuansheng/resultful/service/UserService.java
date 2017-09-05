package com.yuansheng.resultful.service;

import java.util.List;

import com.yuansheng.resultful.domain.User;
/**
 * 
 * @author HuangHang
 *
 * service 实现crud
 *
 */
public interface UserService {
	public List<User> listUser();

	public void addUser(String name, Integer sex);
	
	public void deleteUserById(Integer id);
	
	public void updateUserById(User user);
}
