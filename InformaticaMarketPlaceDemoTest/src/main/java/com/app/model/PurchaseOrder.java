package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purchaseorder_tab")
public class PurchaseOrder {
	@Id
	@GeneratedValue(generator="pogen")
	@GenericGenerator(name="pogen",strategy="increment")
	@Column(name="po_id")
	private Integer poId;
	@Column(name="po_code")
	private String orderCode;
	@Column(name="ref_no")
	private String referenceNo;
	@Column(name="quality_check")
	private String qualityCheck;
	@Column(name="default_status")
	private String defaultStatus;
	private String dsc;
	@ManyToOne
	@JoinColumn(name="shipmentcodeId")
	private ShipmentType shipmentcode;
	
	@ManyToOne
	@JoinColumn(name="whvendorId")
	private WhUserType vendor;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer poId) {
		super();
		this.poId = poId;
	}

	public PurchaseOrder(Integer poId, String orderCode, String referenceNo, String qualityCheck, String defaultStatus,
			String dsc, ShipmentType shipmentcode, WhUserType vendor) {
		super();
		this.poId = poId;
		this.orderCode = orderCode;
		this.referenceNo = referenceNo;
		this.qualityCheck = qualityCheck;
		this.defaultStatus = defaultStatus;
		this.dsc = dsc;
		this.shipmentcode = shipmentcode;
		this.vendor = vendor;
	}

	public Integer getPoId() {
		return poId;
	}

	public void setPoId(Integer poId) {
		this.poId = poId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	public ShipmentType getShipmentcode() {
		return shipmentcode;
	}

	public void setShipmentcode(ShipmentType shipmentcode) {
		this.shipmentcode = shipmentcode;
	}

	public WhUserType getVendor() {
		return vendor;
	}

	public void setVendor(WhUserType vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [poId=" + poId + ", orderCode=" + orderCode + ", referenceNo=" + referenceNo
				+ ", qualityCheck=" + qualityCheck + ", defaultStatus=" + defaultStatus + ", dsc=" + dsc
				+ ", shipmentcode=" + shipmentcode + ", vendor=" + vendor + "]";
	}
}
