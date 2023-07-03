package com.brandonn.springboottemplate2.products.integration.database;

import com.brandonn.springboottemplate2.products.integration.database.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
