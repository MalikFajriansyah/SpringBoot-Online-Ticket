package com.ticketonline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Ticket")
public class Ticket {
	
	@Id
	@Column(name = "Ticket_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Ticket_Id;
	
	@Column(name = "Film")
	private String film;
	
	@Column(name = "Date")
	private String Jadwal;
	
	@Column(name = "Start_Time")
	private String Start;
	
	@Column(name = "Finish_Time")
	private String End;
	
	@Column(name = "Quantity")
	private int JumlahTiket;
	
	public int getTicketId() {
		return Ticket_Id;
	}
	public void setTicketId(int Ticket_Id) {
		this.Ticket_Id = Ticket_Id;
	}
	
	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}
	
	public String getJadwal() {
		return Jadwal;
	}
	public void setJadwal(String Jadwal) {
		this.Jadwal = Jadwal;
	}
	
	public String getStart() {
		return Start;
	}
	public void setStart(String Start) {
		this.Start = Start;
	}
	
	public String getEnd() {
		return End;
	}
	public void setEnd(String End) {
		this.End = End;
	}
	
	public int getJumlahTiket() {
		return JumlahTiket;
	}
	public void setJumlahTiket(int JumlahTiket) {
		this.JumlahTiket = JumlahTiket;
	}
}
