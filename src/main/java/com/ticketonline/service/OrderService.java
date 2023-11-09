package com.ticketonline.service;


import java.util.List;
import java.util.Map;

import com.ticketonline.model.Order;
import com.ticketonline.model.dto.DataOrderDto;

public interface OrderService {
	
	//add order
	void addOrder(Order order);
	
	//list order
	List<Order> listOrder();
	
	List<Map<String, Object>> orderData();
	
	List<DataOrderDto> listData();
}
