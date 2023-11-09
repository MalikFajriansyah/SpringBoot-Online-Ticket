package com.ticketonline.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ticketonline.model.Customer;
import com.ticketonline.repository.CustomerRepository;
import com.ticketonline.service.CustomerService;

@Service
public class CustomerServiceImpl  implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	//all 
	@Override
	public List<Customer> fetchCustomerList() {
		return (List<Customer>)customerRepo.findAll();
	}

	@Override
	public Optional<Customer> getCustId(Integer custId) {
		return customerRepo.findById(custId);
	}

	@Override
	public List<Customer> custByNama(String nama) {
		return customerRepo.searchByNama(nama);
	}
	
}
