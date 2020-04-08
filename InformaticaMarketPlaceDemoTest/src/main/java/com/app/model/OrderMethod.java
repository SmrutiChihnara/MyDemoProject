package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ormethodtab")
public class OrderMethod {
	@Id
	@Column(name="order_id")
	@GeneratedValue(generator="ormethodgen")
	@GenericGenerator(name="ormethodgen",strategy="increment")
	private Integer orderId;
	@Column(name="order_mode")
	private String orderMode;
	@Column(name="order_code")
	private String orderCode;
	@Column(name="order_method")
	private String orderMethod;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="omaccepttab",joinColumns=@JoinColumn(name="order_id"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private List<String> orderAccept;
	private String dsc;
	
	public OrderMethod() {
		super();
	}

	public OrderMethod(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public OrderMethod(Integer orderId, String orderMode, String orderCode, String orderMethod,
			List<String> orderAccept, String dsc) {
		super();
		this.orderId = orderId;
		this.orderMode = orderMode;
		this.orderCode = orderCode;
		this.orderMethod = orderMethod;
		this.orderAccept = orderAccept;
		this.dsc = dsc;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderMethod() {
		return orderMethod;
	}

	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}

	public List<String> getOrderAccept() {
		return orderAccept;
	}

	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "OrderMethod [orderId=" + orderId + ", orderMode=" + orderMode + ", orderCode=" + orderCode
				+ ", orderMethod=" + orderMethod + ", orderAccept=" + orderAccept + ", dsc=" + dsc + "]";
	}
	
	

	
}
