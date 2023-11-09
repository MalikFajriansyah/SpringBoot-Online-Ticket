package com.ticketonline.model.dto;

import lombok.Data;

@Data
public class DataOrderDto {
	
	private int order_id;
	private int Cust_Id;
	private String Nama;
	private String Email;
	private int Ticket_Id;
	private String Film;
	private String Date;
	private int order_quantity;
	
	public DataOrderDto(int order_id, int Cust_Id, String Nama, String Email, int Ticket_Id, String Film, String Date, int order_quantity) {
		this.order_id = order_id;
		this.Cust_Id = Cust_Id;
		this.Nama = Nama;
		this.Email = Email;
		this.Ticket_Id = Ticket_Id;
		this.Film = Film;
		this.Date = Date;
		this.order_quantity = order_quantity;
	}
	
	public int getOrderId() {
		return order_id;
	}
	public void setOrderId(int order_id) {
		this.order_id = order_id;
	}
	
	public int getCustId() {
		return Cust_Id;
	}
	public void setCustId(int custId) {
		this.Cust_Id = custId;
	}
	
	public String getNama() {
		return Nama;
	}
	public void setNama(String nama) {
		this.Nama = nama;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	
	public int getTicketId() {
		return Ticket_Id;
	}
	public void setTicketId(int ticketId) {
		this.Ticket_Id = ticketId;
	}
	
	public String getFilm() {
		return Film;
	}
	public void setFilm(String film) {
		this.Film = film;
	}
	
	public String getJadwal() {
		return Date;
	}
	public void setJadwal(String Date) {
		this.Date = Date;
	}
}
