package com.ticketonline.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ticketonline.model.Order;
import com.ticketonline.model.dto.DataOrderDto;
import com.ticketonline.repository.OrderRepository;
import com.ticketonline.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public void addOrder(Order order) {
		orderRepo.save(order);
	}

	@Override
	public List<Order> listOrder() {
		return orderRepo.findAll();
	}

	@Override
	public List<Map<String,Object>> orderData() {
		return orderRepo.findOrderData();
	}

	@Override
	public List<DataOrderDto> listData() {
		return orderRepo.findDataOrder();
	}
}