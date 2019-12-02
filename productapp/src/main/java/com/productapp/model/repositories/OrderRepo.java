package com.productapp.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.Order;
@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

}
