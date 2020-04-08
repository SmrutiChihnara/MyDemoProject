package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shipmentTypetab")
public class ShipmentType {
	@Id
	@GeneratedValue(generator="shipmentTypegen")
	@GenericGenerator(name="shipmentTypegen",strategy="increment")
	@Column(name="sid")
	private Integer shipmentTypeId;
	@Column(name="smode")
	private String shipmentTypeMode;
	@Column(name="scode")
	private String shipmentTypeCode;
	@Column(name="enable_shipment")
	private String enableShipment;
	private String grade;
	private String dsc;

	public ShipmentType() {
		super();
	}

	public ShipmentType(Integer shipmentTypeId) {
		super();
		this.shipmentTypeId = shipmentTypeId;
	}

	public ShipmentType(Integer shipmentTypeId, String shipmentTypeMode, String shipmentTypeCode, String enableShipment,
			String grade, String dsc) {
		super();
		this.shipmentTypeId = shipmentTypeId;
		this.shipmentTypeMode = shipmentTypeMode;
		this.shipmentTypeCode = shipmentTypeCode;
		this.enableShipment = enableShipment;
		this.grade = grade;
		this.dsc = dsc;
	}

	public Integer getShipmentTypeId() {
		return shipmentTypeId;
	}

	public void setShipmentTypeId(Integer shipmentTypeId) {
		this.shipmentTypeId = shipmentTypeId;
	}

	public String getShipmentTypeMode() {
		return shipmentTypeMode;
	}

	public void setShipmentTypeMode(String shipmentTypeMode) {
		this.shipmentTypeMode = shipmentTypeMode;
	}

	public String getShipmentTypeCode() {
		return shipmentTypeCode;
	}

	public void setShipmentTypeCode(String shipmentTypeCode) {
		this.shipmentTypeCode = shipmentTypeCode;
	}

	public String getEnableShipment() {
		return enableShipment;
	}

	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "ShipmentType [shipmentTypeId=" + shipmentTypeId + ", shipmentTypeMode=" + shipmentTypeMode
				+ ", shipmentTypeCode=" + shipmentTypeCode + ", enableShipment=" + enableShipment + ", grade=" + grade
				+ ", dsc=" + dsc + "]";
	}
}
