package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipmentType(ShipmentType sType);
	public void updateShipmentType(ShipmentType sType);
	public void deleteShipmentType(Integer shipmentTypeId);
	public ShipmentType getOneShipmentType(Integer shipmentTypeId);
	public List<ShipmentType> getAllShipmentTypes();
	public List<ShipmentType> getShipmentTypes(String enableShipment);
}
