package com.ticketonline.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ticketonline.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query(value ="select p from Ticket p where concat (p.film) LIKE %?1%")
	List<Ticket> findByFilm(String keyword);
	
	Ticket findById(int ticketId);
}
