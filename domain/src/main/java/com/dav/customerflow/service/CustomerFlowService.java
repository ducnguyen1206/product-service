package com.dav.customerflow.service;

import com.dav.customerflow.dto.CategoryDto;
import com.dav.customerflow.dto.ProductDto;
import com.dav.customerflow.dto.ReservationDto;

import java.util.List;

public interface CustomerFlowService {
    void save(ProductDto productRequest, String createdBy);

    List<CategoryDto> getCategoryList(Long categoryId);

    List<ProductDto> getProducts(Long categoryId);

    void submitReservation(ReservationDto request, String user);
}
