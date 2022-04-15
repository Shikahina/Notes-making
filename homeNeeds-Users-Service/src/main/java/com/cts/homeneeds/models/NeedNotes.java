package com.cts.homeneeds.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class NeedNotes {
	
	@Override
	public String toString() {
		return "NeedNotes [id=" + id + ", owner=" + owner + ", need=" + need + ", prefStore=" + prefStore + ", BuyerId="
				+ BuyerId + ", PurchaseStatus=" + PurchaseStatus + ", Price=" + Price + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long owner;
	
	private String need;
	
	private String prefStore;
			
	private Long BuyerId;
	
	private String PurchaseStatus;
	
	private String Price;
	
	
	
	
	
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

	
}
