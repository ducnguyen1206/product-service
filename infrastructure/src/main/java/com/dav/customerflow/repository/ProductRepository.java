package com.dav.customerflow.repository;

import com.dav.customerflow.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByProductName(String productName);

    List<Product> findByCategoryId(Long productName);
}
