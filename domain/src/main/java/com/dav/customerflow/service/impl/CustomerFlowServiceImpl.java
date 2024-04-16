package com.dav.customerflow.service.impl;

import com.dav.customerflow.data.CustomerFlowData;
import com.dav.customerflow.dto.CategoryDto;
import com.dav.customerflow.dto.ProductDto;
import com.dav.customerflow.dto.ReservationDto;
import com.dav.customerflow.entity.*;
import com.dav.customerflow.enumf.StatusEnum;
import com.dav.customerflow.exception.GenericException;
import com.dav.customerflow.mapper.EntityMapper;
import com.dav.customerflow.service.CustomerFlowService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.dav.customerflow.constant.MessageConstant.CATEGORY_RETURN_LOG;
import static com.dav.customerflow.dto.error.ErrorEnum.*;
import static com.dav.customerflow.utils.CommonUtils.toJsonString;

@AllArgsConstructor
@Log4j2
public class CustomerFlowServiceImpl implements CustomerFlowService {

    @Autowired
    private final CustomerFlowData customerFlowData;

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void save(ProductDto productRequest, String createdBy) {
        log.info("Saving product details");

        // Get categoryId
        CategoryDto category = getCategoryByName(productRequest.getCategoryName());
        if (Objects.isNull(category)) {
            log.error( CATEGORY_NOT_FOUND.getMessage());
            throw new GenericException(CATEGORY_NOT_FOUND.getCode(), CATEGORY_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND);
        }

        log.info(CATEGORY_RETURN_LOG, toJsonString(category));

        // Get branchId
        Branch branch = customerFlowData.getBranchByBranchCode(productRequest.getBranchCode());
        if (Objects.isNull(branch)) {
            log.error(BRANCH_NOT_FOUND.getMessage());
            throw new GenericException(BRANCH_NOT_FOUND.getCode(), BRANCH_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND);
        }

        log.info("Branch returned {}", toJsonString(branch));

        Long categoryId = category.getId();
        Long branchId = branch.getId();

        // Validating product name
        if (customerFlowData.existsByProductName(productRequest.getProductName())) {
            log.error("Product name already existed");
            throw new GenericException(PRODUCT_NAME_EXISTED.getCode(), PRODUCT_NAME_EXISTED.getMessage(), HttpStatus.CONFLICT);
        }

        Product product = EntityMapper.INSTANCE.productDtoToProduct(productRequest);
        product.setCategoryId(categoryId);

        product = customerFlowData.save(product);
        log.info("Saved product {}", toJsonString(product));

        ProductBranch productBranch = ProductBranch.builder()
                .productId(product.getId())
                .branchId(branchId)
                .status(StatusEnum.ACTIVE.name())
                .build();
        log.info("Saving new product branch {}", toJsonString(productBranch));

        customerFlowData.saveProductBranch(productBranch);
    }

    @Override
    public List<CategoryDto> getCategoryList(Long categoryId) {
        log.info("Get categories");
        if (Objects.nonNull(categoryId)) {
            CategoryDto response = getCategoryById(categoryId);
            return Objects.nonNull(response) ? List.of(response) : Collections.emptyList();
        }

        log.info("Get all categories");
        return EntityMapper.INSTANCE.categoryListToCategoryDtoList(customerFlowData.getAllCategory());
    }

    @Override
    public List<ProductDto> getProducts(Long categoryId) {
        if (Objects.nonNull(categoryId)) {
            log.info("Get product details by categoryId {}", categoryId);
            List<Product> product = customerFlowData.getProductByCategoryId(categoryId);
            log.info("Product returned {}", toJsonString(product));
            return EntityMapper.INSTANCE.productListToProductDtoList(product);
        }

        log.info("Get all products");
        return EntityMapper.INSTANCE.productListToProductDtoList(customerFlowData.getAllProducts());
    }

    @Override
    public void submitReservation(ReservationDto request, String user) {
        // check branch
        Long branchId = request.getBranchId();
        Branch branch = customerFlowData.findBranchByBranchId(branchId);
        if (Objects.isNull(branch)) {
            log.error("Branch not found");
            throw new GenericException(BRANCH_NOT_FOUND.getCode(), BRANCH_NOT_FOUND.getMessage(), HttpStatus.NOT_FOUND);
        }

        // save to reservation table
        Reservation reservation = EntityMapper.INSTANCE.reservationDtoToReservation(request);
        reservation.setStatus(StatusEnum.ACTIVE.name());
        log.info("Reservation info: {}", toJsonString(reservation));
        customerFlowData.saveReservation(reservation);

        // TODO send notification
    }

    private CategoryDto getCategoryByName(String categoryName) {
        log.info("Get category by name {}", categoryName);
        Category category = customerFlowData.getCategoryByCategoryName(categoryName);
        if (Objects.isNull(category)) {
            log.info("No category found for this name");
            return null;
        }

        log.info(CATEGORY_RETURN_LOG, toJsonString(category));
        return EntityMapper.INSTANCE.categoryToCategoryDto(category);
    }

    private CategoryDto getCategoryById(Long categoryId) {
        log.info("Get category by id {}", categoryId);
        Category category = customerFlowData.getCategoryByCategoryId(categoryId);
        if (Objects.isNull(category)) {
            log.info("No category found for this id");
            return null;
        }

        log.info(CATEGORY_RETURN_LOG, toJsonString(category));
        return EntityMapper.INSTANCE.categoryToCategoryDto(category);
    }
}
