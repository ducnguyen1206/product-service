package com.dav.customerflow.service.impl;

import com.dav.customerflow.data.CustomerFlowData;
import com.dav.customerflow.dto.ProductDto;
import com.dav.customerflow.entity.Product;
import com.dav.customerflow.mapper.EntityMapper;
import com.dav.customerflow.service.CustomerFlowService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class CustomerFlowServiceImpl implements CustomerFlowService {

    @Autowired
    private final CustomerFlowData customerFlowData;

    @Override
    public void save(ProductDto productRequest, String createdBy) {
        Product product = EntityMapper.INSTANCE.productDtoToProduct(productRequest);
        customerFlowData.save(product);
    }
}
