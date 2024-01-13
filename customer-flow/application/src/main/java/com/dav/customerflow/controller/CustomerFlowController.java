package com.dav.customerflow.controller;

import com.dav.customerflow.dto.ProductDto;
import com.dav.customerflow.service.CustomerFlowService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.dav.customerflow.constant.UrlConstant.*;

@RestController
@CrossOrigin
@RequestMapping(API_VERSION_1)
public class CustomerFlowController {

    @Autowired
    private CustomerFlowService customerFlowService;

    @PostMapping(value = SAVE_PRODUCT)
    @Operation(summary = "Get product(s) details")
    public ResponseEntity<Object> getProductDetails() {
        customerFlowService.save(new ProductDto());
        return ResponseEntity.ok().build();
    }
}
