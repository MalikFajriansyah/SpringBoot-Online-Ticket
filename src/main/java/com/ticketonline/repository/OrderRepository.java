package com.ticketonline.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ticketonline.model.Order;
import com.ticketonline.model.dto.DataOrderDto;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query(value = "select a.order_id, a.Cust_Id, b.Nama, b.Email, a.Ticket_Id, c.Film, c.Date, a.order_quantity " +
			"from tbl_order a " +
			"inner join Customer b on b.Cust_Id = a.Cust_Id " +
			"inner join Ticket c on c.Ticket_Id = a.Cust_Id " , nativeQuery = true)
	List<Map<String, Object>> findOrderData();
	
	@Query(value = "select a.order_id, a.Cust_Id, b.Nama, b.Email, a.Ticket_Id, c.Film, c.Date, a.order_quantity " +
			"from tbl_order a " +
			"inner join Customer b on b.Cust_Id = a.Cust_Id " +
			"inner join Ticket c on c.Ticket_Id = a.Cust_Id " , nativeQuery = true)
	List<DataOrderDto> findDataOrder();
}