package com.ticketonline.service;

import java.util.List;
import java.util.Optional;
import com.ticketonline.model.Customer;

public interface CustomerService {
	//read
	List<Customer> fetchCustomerList();
	List<Customer> custByNama(String nama);
	
	Optional<Customer> getCustId(Integer custId);
}
