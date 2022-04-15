package com.cts.homeneeds.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class NeedNotes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long owner;
	
	private String need;
	
	private String prefStore;
			
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getNeed() {
		return need;
	}

	public void setNeed(String need) {
		this.need = need;
	}

	public String getPrefStore() {
		return prefStore;
	}

	public void setPrefStore(String prefStore) {
		this.prefStore = prefStore;
	}

	

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	public Long getBuyerId() {
		return BuyerId;
	}

	public void setBuyerId(Long buyerId) {
		BuyerId = buyerId;
	}

	public String getPurchaseStatus() {
		return PurchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		PurchaseStatus = purchaseStatus;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	private Long BuyerId;
	
	private String PurchaseStatus;
	
	private String Price;
}
