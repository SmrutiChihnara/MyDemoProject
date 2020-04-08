package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	@Autowired
	private IOrderMethodDao dao;

	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod orMethod) {
		return dao.saveOrderMethod(orMethod);
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod orMethod) {
		dao.updateOrderMethod(orMethod);
	}

	@Override
	@Transactional
	public void deleteOrderMethod(Integer orderId) {
		dao.deleteOrderMethod(orderId);
	}

	@Override
	@Transactional(readOnly=true)
	public OrderMethod getOneOrderMethod(Integer orderId) {
		return dao.getOneOrderMethod(orderId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrderMethods() {
		return dao.getAllOrderMethods();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getOrderMethodByMode(String orderMode) {
		return dao.getOrderMethodByMode(orderMode);
	}
	
	@Override
	public boolean isOrederMethodAlreadyExist(String orderMode) {
		
		return false;
	}
}
