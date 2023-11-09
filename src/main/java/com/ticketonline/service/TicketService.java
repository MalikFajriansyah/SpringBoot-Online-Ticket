package com.ticketonline.service;

import java.util.List;
import java.util.Optional;
import com.ticketonline.model.Ticket;

public interface TicketService {
	
	List<Ticket> ticketList();
	List<Ticket> listFilm(String keyword);
	List<Ticket> listByFilm(String film);
	void addFilm(Ticket ticket);
	Ticket filmId(Integer ticketId) throws Exception;
	
	Optional<Ticket> filmById(Integer ticketId) throws Exception;
	
	void updateQuantity(int order_quantity, int JumlahTiket);
	
}
