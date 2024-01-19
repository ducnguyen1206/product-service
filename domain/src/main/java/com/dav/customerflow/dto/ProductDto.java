package com.dav.customerflow.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(required = true, example = "Makizushi")
    @NotBlank(message = "Product is required")
    private String productName;

    @Schema(required = true)
    @NotNull(message = "Price is required")
    private BigDecimal price;

    @Schema(required = true, example = "Sushi")
    @NotNull(message = "Category Name is required")
    private String categoryName;

    @Schema(required = true, example = "VND")
    @NotNull(message = "Currency is required")
    private String currency;

    @Schema(required = true)
    @NotNull(message = "Default quantity Id is required")
    private Integer defaultQuantity;

    @Schema(required = true, example = "501")
    private int branchCode;

    @Schema(example = "1 roll (4 pieces)")
    private String description;
}
