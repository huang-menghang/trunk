package com.yuansheng.resutful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yuansheng.resultful.core.common.JsonResult;
import com.yuansheng.resultful.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService entityService;

	// 列出所有的用户
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public ModelAndView editUser() {
		ModelAndView view = new ModelAndView("user/index");
		view.addObject("users", entityService.listUser());
		return view;
	}

	// 添加用户
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	public String addUser() {
		JsonResult jsonResult = JsonResult.getInstance(0, "添加成功");
		return jsonResult.toString();
	}

	// 获取某个用户的信息
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String editUser(@PathVariable("userId") String userId) {
		JsonResult jsonResult = JsonResult.getInstance(0, "获取用户成功");
		return jsonResult.toString();
	}

	// 修改某个用户的信息
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "text/json;charset=UTF-8")
	public String updateUser(@PathVariable("userId") String userId) {
		JsonResult jsonResult = JsonResult.getInstance(0, "修改成功");
		return jsonResult.toString();
	}
    // 删除某个某个用户
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String deleteUser(@PathVariable("userId") String userId) {
		System.out.println(userId);
		JsonResult jsonResult = JsonResult.getInstance(0, "删除用户");
		return jsonResult.toString();
	}

}
