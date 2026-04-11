package com.example.orderservice.dto;

import jakarta.validation.constraints.Min;

public class OrderRequest {
    private Long userId;
    private Long productId;
    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;
    
    public OrderRequest() {
    	
    }
    
	public OrderRequest(Long userId, Long productId, int quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderRequest [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
    
}