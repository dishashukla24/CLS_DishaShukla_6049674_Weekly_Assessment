package com.demo.assessment;

import java.time.LocalDate;
import java.util.*;

import com.demo.assessment.entities.Order;

public class DaoClient {
    static OrderDao dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);
        
	public static void main(String[] args) {
		String opt = null;
		do {
			System.out.println("1-ADD, 2--VIEW BY ORDER ID, 3--VIEW BY CUSTOMER NAME");
			int mtype = scan.nextInt();
			processMenu(mtype);
			System.out.println("press y to continue");
			opt=scan.next();
		}while(opt.equalsIgnoreCase("y"));

	}
	
	public static void processMenu(int mtype) {
		switch(mtype) {
		case 1:
			addOrder();
			break;
		case 2:
			viewOrderByOrderID();
			break;
		case 3:
			viewOrdersByCustName();
			break;
		default:
			System.out.println("Invalid option");
		}
	}

	public static void addOrder() {
		Order o = new Order();
		o.setOrder_date(LocalDate.now());
		System.out.println("Enter customers Id: ");
		int id = scan.nextInt();
		System.out.print("Enter amount: ");
		Double amount = scan.nextDouble();
		o.setOrder_amt(amount);
		
		boolean b = dao.addOrder(o,id);
		if(b) System.out.println("Order added");
		else System.out.println("Order already exists");	
	}
	
	public static void viewOrderByOrderID() {
		System.out.print("Enter Order Id: ");
		int id1 = scan.nextInt();
		System.out.println();
		Order o1 = dao.getOrder(id1);
		if(o1!=null)
		System.out.println(o1);
		
	}
	
	public static void viewOrdersByCustName() {
		scan.nextLine();
		System.out.print("Enter Customer name: ");
		String name = scan.nextLine();
		List<Order> l=dao.getOrders(name);
		for(Order od : l){
			System.out.println(od);
		}
		
	}
 }







