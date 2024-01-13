package com.dav.customerflow.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    @NotBlank(message = "Product is required")
    private String productName;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotNull(message = "Category Id is required")
    private Long categoryId;

    @NotNull(message = "Default quantity Id is required")
    private Integer defaultQuantity;
}
