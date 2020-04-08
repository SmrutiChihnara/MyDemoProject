package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod orMethod) {

		return (Integer) ht.save(orMethod);
	}

	@Override
	public void updateOrderMethod(OrderMethod orMethod) {
		ht.update(orMethod);
	}

	@Override
	public void deleteOrderMethod(Integer orderId) {
		OrderMethod orMethod=new OrderMethod();
		orMethod.setOrderId(orderId);
		ht.delete(orMethod);
	}

	@Override
	public OrderMethod getOneOrderMethod(Integer orderId) {
		return ht.get(OrderMethod.class, orderId);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}
	
	@Override
	public List<OrderMethod> getOrderMethodByMode(String orderMode) {
		@SuppressWarnings("unchecked")
		List<OrderMethod> orMethods=(List<OrderMethod>) ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class).add(Restrictions.eq("orderMode",orderMode)));
		return orMethods;
	}
	
	@Override
	public boolean isOrederMethodAlreadyExist(String orderMode) {
	//select count(*) from omtab where order_mode=?
		
		@SuppressWarnings("unchecked")
		List<Long> countlist=(List<Long>)
		ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("orderMode", orderMode))
				
				);
		return countlist.get(0)!=0?true:false;
	}
}
