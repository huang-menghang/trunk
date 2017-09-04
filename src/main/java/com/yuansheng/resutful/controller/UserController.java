package com.yuansheng.resutful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yuansheng.resultful.core.common.JsonResult;

@Controller
@RequestMapping(value="/user/*")
public class UserController {
    @RequestMapping(value="/user/*",method=RequestMethod.POST,produces="text/json;charset=UTF-8")
	public String addUser(){
    	JsonResult jsonResult = JsonResult.getInstance(0, "添加成功");
   		return jsonResult.toString();
	}
	
    @RequestMapping(value="/user/*",method=RequestMethod.DELETE,produces="text/json;charset=UTF-8")
   	public String deleteUser(){
   		JsonResult jsonResult = JsonResult.getInstance(0, "删除成功");
   		return jsonResult.toString();
   	}
    
    @RequestMapping(value="/user/*",method=RequestMethod.PUT,produces="text/json;charset=UTF-8")
   	public String updateUser(){
    	JsonResult jsonResult = JsonResult.getInstance(0, "修改成功");
   		return jsonResult.toString();
   	}
    
    @RequestMapping(value="/user/*",method=RequestMethod.GET,produces="text/json;charset=UTF-8")
   	public String selectUser(){
    	JsonResult jsonResult = JsonResult.getInstance(0, "查找成功");
   		return jsonResult.toString();
   	}
	
	
}
