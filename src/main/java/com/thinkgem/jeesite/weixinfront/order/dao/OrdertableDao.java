/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.weixinfront.order.dao;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.weixin.system.entity.WeixinUserInfo;
import com.thinkgem.jeesite.weixinfront.order.entity.OrderTableDetail;
import com.thinkgem.jeesite.weixinfront.order.entity.Ordertable;

/**
 * 订单表DAO接口
 * @author janson
 * @version 2016-04-25
 */
@MyBatisDao
public interface OrdertableDao extends CrudDao<Ordertable> {

	List<Ordertable> findAdminUndoneOrder();

	List<Ordertable> findALlByUser(WeixinUserInfo weixinUserInfo);

	List<Ordertable> findAdmindoneOrder();

	OrderTableDetail findOrderTableDetailById(String id);

	List<OrderTableDetail> getOrderByBeginAndEnd(Map<String, String> datemap);
	
}