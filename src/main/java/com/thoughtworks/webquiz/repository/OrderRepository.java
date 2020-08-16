package com.thoughtworks.webquiz.repository;

import com.thoughtworks.webquiz.dto.OrderDto;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderDto, Integer> {

}
