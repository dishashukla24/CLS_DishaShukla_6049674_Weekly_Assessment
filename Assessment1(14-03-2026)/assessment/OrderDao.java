package com.demo.assessment;

import java.util.List;

import com.demo.assessment.entities.Order;

public interface OrderDao {
		public boolean addOrder(Order order, int custId);
		public Order getOrder(int orderId);
		public List<Order> getOrders(String custName);
}
