package com.ticketonline.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ticketonline.model.Customer;
import com.ticketonline.model.Order;
import com.ticketonline.model.Ticket;
import com.ticketonline.repository.TicketRepository;
import com.ticketonline.service.CustomerService;
import com.ticketonline.service.OrderService;
import com.ticketonline.service.TicketService;

@Controller
@RequestMapping("/ticketonline")
public class OrderController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketRepository ticketRepo;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderService orderService;
	
	//add new film
	@GetMapping("addnew")
	public String addNewFilm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("film", ticket);
		return "addfilm";
	}
	//post new film
	@PostMapping("savefilm")
	public String saveNewFilm(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.addFilm(ticket);
		return "redirect:list";
	}
	
	//list film
	@GetMapping("list")
	public String filmList(Model model, @Param("keyword") String keyword){
		List<Ticket> ticket = ticketService.listFilm(keyword);
		model.addAttribute("tickets", ticket);
		model.addAttribute("keyword", keyword);
		return "index";
	}
	
	//list customer
	@GetMapping("customer")
	public String custList(Model model) {
		List<Customer> customer = customerService.fetchCustomerList();
		model.addAttribute("Cus", customer);
		return "getcust";
	}
	
	//get cust by id
	@GetMapping("custid")
	public String pesenTiket( Model model, Integer custId){
		customerService.getCustId(custId).ifPresent(o -> model.addAttribute("cus", o));
		return "getcust";
	}
	
	//get film by id
	@GetMapping("dataFilm")
	public String formPesanTiket(Model model,Integer ticketId){
		Ticket ticket = null;
		try {
			ticket = ticketService.filmId(ticketId);
		} catch (Exception ex) {
			model.addAttribute("errorMessage", "Film Not Found");
		}
		model.addAttribute("tickets", ticket);
		return "order";
	}
	
	//pindah form order
	@GetMapping("pesantiket")
	public String orderForm(Model model) {
		Order order = new Order();
		model.addAttribute("order", order);
		return "orderticket";
	}
	
	//add order
	@PostMapping("order")
	public String orderFilm(@ModelAttribute("order") Order order, Integer order_quantity, int ticketId){
		Ticket ticket = ticketRepo.findById(ticketId);
		order_quantity = order.getOrderQty();
		if (order_quantity > ticket.getJumlahTiket() || order_quantity <= 0) {
			return "orderrejected";
		} else {
			orderService.addOrder(order);
			ticketService.updateQuantity(order.getOrderQty(), order.getTicketId());
			return "ordersuccess";
		}
	}
	
	//pindah test form
	@GetMapping("searchcustomer")
	public String getFilmForm() {

		return "getcust";
	}
	
	@GetMapping("yourorder")
	public String orderListForm(Model model) {
		List<Map<String,Object>> order = orderService.orderData();
		model.addAttribute("dataorder", order);
		return "yourorder";
	}
}

