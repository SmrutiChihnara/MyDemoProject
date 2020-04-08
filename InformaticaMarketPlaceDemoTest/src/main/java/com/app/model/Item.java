package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author:Smruti
 *  Generated F/w:SHWR-Framework 
 */
@Entity
@Table(name = "itemtab")
public final class Item {
	@Id
	@GeneratedValue(generator="itm_gen")
	@GenericGenerator(name="itm_gen",strategy="increment")
	@Column(name = "id")
	private Integer id;

	@Column(name = "itm_code")
	private String itemCode;
	@Column(name = "itm_wd")
	private double itemWdth;
	@Column(name = "itm_len")
	private double itemLen;
	@Column(name = "itm_ht")
	private double itemHght;
	@Column(name = "itm_cost")
	private double baseCost;
	@Column(name = "itm_curr")
	private String baseCurrecy;
	@Column(name = "itm_dsc")
	private String itemDsc;

	//Multiplicticy with UOM
	@ManyToOne
	@JoinColumn(name="uidFk")
	private Uom uom;
	
	@ManyToOne
	@JoinColumn(name="omSaleId")
	private OrderMethod saleType;
	@ManyToOne
	@JoinColumn(name="omPurchaseId")
	private OrderMethod purchaseType;

	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_venusr_tab",
		joinColumns=@JoinColumn(name="itmaIdFk"),
		inverseJoinColumns=@JoinColumn(name="venIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> venUsers=new ArrayList<WhUserType>(0);

	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="itm_custs_tab",
		joinColumns=@JoinColumn(name="itmbIdFk"),
		inverseJoinColumns=@JoinColumn(name="custIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> custUsers=new ArrayList<WhUserType>(0);
	
	public Item() {
		super();
	}
	
	public Item(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public double getItemWdth() {
		return itemWdth;
	}

	public void setItemWdth(double itemWdth) {
		this.itemWdth = itemWdth;
	}

	public double getItemLen() {
		return itemLen;
	}

	public void setItemLen(double itemLen) {
		this.itemLen = itemLen;
	}

	public double getItemHght() {
		return itemHght;
	}

	public void setItemHght(double itemHght) {
		this.itemHght = itemHght;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	public String getBaseCurrecy() {
		return baseCurrecy;
	}

	public void setBaseCurrecy(String baseCurrecy) {
		this.baseCurrecy = baseCurrecy;
	}

	public String getItemDsc() {
		return itemDsc;
	}

	public void setItemDsc(String itemDsc) {
		this.itemDsc = itemDsc;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderMethod getSaleType() {
		return saleType;
	}

	public void setSaleType(OrderMethod saleType) {
		this.saleType = saleType;
	}

	public OrderMethod getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}

	public List<WhUserType> getVenUsers() {
		return venUsers;
	}

	public void setVenUsers(List<WhUserType> venUsers) {
		this.venUsers = venUsers;
	}

	public List<WhUserType> getCustUsers() {
		return custUsers;
	}

	public void setCustUsers(List<WhUserType> custUsers) {
		this.custUsers = custUsers;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemCode=" + itemCode + ", itemWdth=" + itemWdth + ", itemLen=" + itemLen
				+ ", itemHght=" + itemHght + ", baseCost=" + baseCost + ", baseCurrecy=" + baseCurrecy + ", itemDsc="
				+ itemDsc + ", uom=" + uom + ", saleType=" + saleType + ", purchaseType=" + purchaseType + ", venUsers="
				+ venUsers + ", custUsers=" + custUsers + "]";
	}

		
}