package com.dav.customerflow.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import static com.dav.customerflow.constant.DatabaseConstant.TBL_PRODUCT;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TBL_PRODUCT)
public class Product extends BaseEntity {
    @NotBlank(message = "Product is required")
    private String productName;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotBlank(message = "Currency is required")
    private String currency;

    @NotNull(message = "Category Id is required")
    private Long categoryId;

    @NotNull(message = "Default quantity Id is required")
    private Integer defaultQuantity;

    private String description;
}
