package com.ticketonline.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ticketonline.model.Ticket;
import com.ticketonline.repository.TicketRepository;
import com.ticketonline.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepo;
	
	@Override
	public List<Ticket> ticketList() {
		return (List<Ticket>) ticketRepo.findAll();
	}
	
	//for show on thymeleaf
	@Override
	public List<Ticket> listFilm(String keyword) {
		
		if(keyword != null) {
			return ticketRepo.findByFilm(keyword);
		}
		return ticketRepo.findAll();
	}
	
	@Override
	public List<Ticket> listByFilm(String keyword) {
		return ticketRepo.findByFilm(keyword);
	}
	
	@Override
	public Optional<Ticket> filmById(Integer ticketId) throws Exception {
		return ticketRepo.findById(ticketId);
	}
	
	@Override
	public void updateQuantity(int order_quantity, int ticketId){
		Ticket ticket = ticketRepo.findById(ticketId);
		ticket.setJumlahTiket(ticket.getJumlahTiket() - order_quantity);
		ticketRepo.save(ticket);
	}

	@Override
	public void addFilm(Ticket ticket) {
		ticketRepo.save(ticket);
	}
	
	@Override
	public Ticket filmId(Integer ticketId) throws Exception {
		
		Ticket ticket = ticketRepo.findById(ticketId).orElse(null);
		if (ticket == null) {
			throw new Exception("Can't Find Film with Id:" + ticketId);
		}
		else return ticket;
	}
	
}
