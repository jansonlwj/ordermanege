package com.thinkgem.jeesite.weixinfront.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.weixinfront.order.entity.Ordertable;
import com.thinkgem.jeesite.weixinfront.order.service.OrdertableService;

/**
 * 微信订单表
 */
@Controller
@RequestMapping(value = "${weixinPath}/weixinOrder")
public class WeixinOrderController extends BaseController {
	
	@Autowired
	private OrdertableService ordertableService;

	/**
	 * 微信首页订单
	 */
	@RequestMapping(value = "findALlByUser")
	@ResponseBody
	public List<Ordertable> findALlByUser(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		//System.out.println(JsonMapper.toJsonString(ordertableService.findALlByUser(request)));
		return ordertableService.findALlByUser(request);
	}
	
	/**
	 * 管理员未完成订单
	 */
	@RequestMapping(value = "admin/undoneOrder")
	@ResponseBody
	public List<Ordertable> undoneOrder(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return ordertableService.findAdminUndoneOrder();
	}
	/**
	 * 管理员完成订单
	 */
	@RequestMapping(value = "admin/doneOrder")
	@ResponseBody
	public List<Ordertable> doneOrder(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return ordertableService.findAdmindoneOrder();
	}
}
