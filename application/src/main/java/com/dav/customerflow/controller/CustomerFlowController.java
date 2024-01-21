package com.dav.customerflow.controller;

import com.dav.customerflow.dto.CategoryDto;
import com.dav.customerflow.dto.ProductDto;
import com.dav.customerflow.dto.ReservationDto;
import com.dav.customerflow.service.CustomerFlowService;
import com.dav.customerflow.utils.SecurityUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static com.dav.customerflow.constant.HeaderConstant.REQUEST_JWT;
import static com.dav.customerflow.constant.UrlConstant.*;

@RestController
@CrossOrigin
@RequestMapping(CUSTOMER_FLOW_V1)
public class CustomerFlowController {

    @Autowired
    private CustomerFlowService customerFlowService;

    @Autowired
    private HttpServletRequest requestHeader;

    @GetMapping(CATEGORY)
    @Operation(summary = "Get all category details")
    public ResponseEntity<List<CategoryDto>> getCategories(@RequestParam(required = false) Long categoryId) {
        return ResponseEntity.ok(customerFlowService.getCategoryList(categoryId));
    }

    @GetMapping(PRODUCTS)
    @Operation(summary = "Get all product details")
    public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(required = false) Long categoryId) {
        return ResponseEntity.ok(customerFlowService.getProducts(categoryId));
    }

    @PostMapping(RESERVATION)
    @Operation(summary = "Submit reservation")
    public ResponseEntity<Object> submitReservation(@Valid @RequestBody ReservationDto request) {
        String user = SecurityUtils.getUser(requestHeader.getHeader(REQUEST_JWT));
        customerFlowService.submitReservation(request, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
