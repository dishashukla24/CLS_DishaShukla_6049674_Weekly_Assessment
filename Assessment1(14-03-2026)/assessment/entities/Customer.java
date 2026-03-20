package com.demo.assessment.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "abes_customer")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Customer_id;
	
	@Column(nullable = false)
	private String Customer_name;
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "cust")
	    private List<Order> order;
		
		public List<Order> getOrder() {
			return order;
		}
	
	@Override
public String toString() {
	return "Customer [Customer_id=" + Customer_id + ", Customer_name=" + Customer_name + "]";
}

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	 
	
	

}

















	  

	

		

	   