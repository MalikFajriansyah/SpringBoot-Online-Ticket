package com.ticketonline.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ticketonline.model.Customer;
import com.ticketonline.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//by id
	@GetMapping("/cust/{Cust_Id}")
	public Optional<Customer>customerById(@PathVariable("Cust_Id") Integer Cust_Id){
		return customerService.getCustId(Cust_Id);
	}
	
	//all
	@GetMapping("/cust")
	public List<Customer> customerList(){
		return customerService.fetchCustomerList();
	}
	
	@GetMapping("/cust/{nama}")
	public List<Customer> searchNama(@PathVariable("nama") String nama){
		return customerService.custByNama(nama);
	}
}
