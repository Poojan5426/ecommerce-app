package com.example.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;

    private String productName;
    private double price;
	public void setProductName(String name) {
		// TODO Auto-generated method stub
		
	}
	public void setPrice(String name) {
		// TODO Auto-generated method stub
		
	}
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setQuantity(int i) {
		// TODO Auto-generated method stub
		
	}
	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}
