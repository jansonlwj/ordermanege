package com.thinkgem.jeesite.weixinfront.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.weixinfront.admin.entity.WeixinAdminUser;
import com.thinkgem.jeesite.weixinfront.admin.service.WeixinAdminUserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/weixinadmin/adminUser")
public class WeixinAdminLoginController {
	
	@Autowired
	WeixinAdminUserService weixinAdminUserService;
	
	@RequestMapping(value = "login",produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> login(String params,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String,Object> result=new HashMap<String, Object>();
		try {
			WeixinAdminUser weixinAdminUser=(WeixinAdminUser) JsonMapper.fromJsonString(params, WeixinAdminUser.class);
			result.putAll(weixinAdminUserService.weixinLogin(weixinAdminUser.getUserName(),weixinAdminUser.getPassword(),request));
		} catch (Exception e) {
			result.put("code", 900);
			result.put("message", "系统出错！");
		}
		return result;
	}

}
