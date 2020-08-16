package com.thoughtworks.webquiz.repository;

import com.thoughtworks.webquiz.dto.ProductDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductDto, Integer> {
    @Override
    List<ProductDto> findAll();
}
