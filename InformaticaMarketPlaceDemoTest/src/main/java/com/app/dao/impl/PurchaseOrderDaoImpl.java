package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.model.WhUserType;
@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder po) {
		return (Integer) ht.save(po);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder po) {
		ht.update(po);

	}

	@Override
	public void deletePurchaseOrder(Integer poId) {
		PurchaseOrder po=new PurchaseOrder();
		po.setPoId(poId);
		ht.delete(po);

	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer poId) {
		return ht.get(PurchaseOrder.class,poId);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return ht.loadAll(PurchaseOrder.class);
	}
}
