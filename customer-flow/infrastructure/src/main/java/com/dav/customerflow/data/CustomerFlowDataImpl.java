package com.dav.customerflow.data;

import com.dav.customerflow.entity.Product;
import com.dav.customerflow.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerFlowDataImpl implements CustomerFlowData {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
