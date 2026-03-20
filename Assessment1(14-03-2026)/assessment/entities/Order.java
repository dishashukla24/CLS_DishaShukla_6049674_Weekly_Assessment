package com.demo.assessment.entities;

import java.time.LocalDate;
import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "abes_order")

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int order_id;
	private LocalDate order_date;
	private double order_amt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer cust;
	
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_date=" + order_date + ", order_amt=" + order_amt + ", cust="
				+ cust + "]";
		
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate localDate) {
		this.order_date = localDate;
	}
	public double getOrder_amt() {
		return order_amt;
	}
	public void setOrder_amt(double order_amt) {
		this.order_amt = order_amt;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	
	

}



	











































	  

	

		

	   