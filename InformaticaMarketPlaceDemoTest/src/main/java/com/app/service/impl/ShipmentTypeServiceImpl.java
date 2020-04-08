package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
	@Autowired
	private IShipmentTypeDao dao;

	@Override
	@Transactional
	public Integer saveShipmentType(ShipmentType sType) {
		return dao.saveShipmentType(sType);
	}

	@Override
	@Transactional
	public void updateShipmentType(ShipmentType sType) {
		dao.updateShipmentType(sType);
	}

	@Override
	@Transactional
	public void deleteShipmentType(Integer shipmentTypeId) {
		dao.deleteShipmentType(shipmentTypeId);
	}

	@Override
	@Transactional(readOnly=true)
	public ShipmentType getOneShipmentType(Integer shipmentTypeId) {
		return dao.getOneShipmentType(shipmentTypeId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() {
		return dao.getAllShipmentTypes();
	}
	@Transactional(readOnly=true)
	public List<ShipmentType> getShipmentTypes(String enableShipment) {
		return dao.getShipmentTypes(enableShipment);
	}
}
