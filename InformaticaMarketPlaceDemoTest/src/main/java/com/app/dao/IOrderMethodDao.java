package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDao {
	public Integer saveOrderMethod(OrderMethod orMethod);
	public void updateOrderMethod(OrderMethod orMethod);
	public void deleteOrderMethod(Integer orderId);
	public OrderMethod getOneOrderMethod(Integer orderId);
	public List<OrderMethod> getAllOrderMethods();
	public List<OrderMethod> getOrderMethodByMode(String orderMode);
	public boolean isOrederMethodAlreadyExist(String orderMode);
}
