package com.ticketonline.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name = "tbl_order")
public class Order {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	
	@Column(name = "Cust_Id")
	private int custId;
	
	@Column(name = "Ticket_Id")
	private int ticketId;
	
	@Column(name = "order_quantity")
	private int orderQty;
	
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "Cust_Id",referencedColumnName = "Cust_Id", insertable = false, updatable = false)
	Customer customer;
	
	@ManyToOne(targetEntity = Ticket.class)
	@JoinColumn(name = "Ticket_Id",referencedColumnName = "Ticket_Id", insertable = false, updatable = false)
	Ticket ticket;
	
	public int getOrderId() {
		return order_id;
	}
	public void setOrderId(int order_id) {
		this.order_id = order_id;
	}
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
}
