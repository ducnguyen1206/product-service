package com.dav.customerflow.controller;

import com.dav.customerflow.dto.ProductDto;
import com.dav.customerflow.service.CustomerFlowService;
import com.dav.customerflow.utils.SecurityUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.dav.customerflow.constant.HeaderConstant.REQUEST_JWT;
import static com.dav.customerflow.constant.UrlConstant.ADMIN_V1;
import static com.dav.customerflow.constant.UrlConstant.PRODUCTS;

@RestController
@CrossOrigin
@RequestMapping(ADMIN_V1)
public class AdminController {
    @Autowired
    private CustomerFlowService customerFlowService;

    @Autowired
    private HttpServletRequest requestHeader;

    @PostMapping(value = PRODUCTS)
    @Operation(summary = "Save product(s) details")
    public ResponseEntity<Object> saveProductDetails(@Valid @RequestBody ProductDto productDto) {
        String user = SecurityUtils.getUser(requestHeader.getHeader(REQUEST_JWT));
        customerFlowService.save(productDto, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
