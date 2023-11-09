package com.ticketonline.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ticketonline.model.Order;
import com.ticketonline.model.Ticket;
import com.ticketonline.model.dto.DataOrderDto;
import com.ticketonline.service.OrderService;
import com.ticketonline.service.TicketService;

@RestController
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/ticket")
	public List<Ticket> ticketList(){
		return ticketService.ticketList();
	}
	
	//by film
	@GetMapping("/ticket/{film}")
	public List<Ticket> byFilm(@PathVariable("film") String film){
		return ticketService.listByFilm(film);
	}
	
	//by id film
	@GetMapping("/ticket/{Ticket_Id}")
	public Optional<Ticket> byId(@PathVariable("Ticket_Id") int Ticket_Id) throws Exception{
		return ticketService.filmById(Ticket_Id);
	}
	
	//list order
	@GetMapping("/order")
	public List<Order> orderdata(){
		return orderService.listOrder();
	}
	
	@GetMapping("/orderdata")
	public List<Map<String,Object>> dataOrder(){
		return orderService.orderData();
	}
	
	@GetMapping("/listdata")
	public List<DataOrderDto> listdata(){
		return orderService.listData();
	}
}
