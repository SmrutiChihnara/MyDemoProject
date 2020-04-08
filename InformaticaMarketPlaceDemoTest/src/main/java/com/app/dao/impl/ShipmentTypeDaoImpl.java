package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveShipmentType(ShipmentType sType) {
		
		return (Integer) ht.save(sType);
	}

	@Override
	public void updateShipmentType(ShipmentType sType) {
		ht.update(sType);

	}

	@Override
	public void deleteShipmentType(Integer shipmentTypeId) {
		ShipmentType sType=new ShipmentType();
		sType.setShipmentTypeId(shipmentTypeId);
		ht.delete(sType);
	}

	@Override
	public ShipmentType getOneShipmentType(Integer shipmentTypeId) {
		return ht.get(ShipmentType.class, shipmentTypeId);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}
	@Override
	public List<ShipmentType> getShipmentTypes(String enableShipment) {
		String hql="from "+ShipmentType.class.getName()+"  where enableShipment=?";
		List<ShipmentType> list=(List<ShipmentType>) ht.find(hql, enableShipment);
		
		return null;
	}

}
