package com.dav.customerflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static com.dav.customerflow.constant.DatabaseConstant.TBL_PRODUCT_BRANCH;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TBL_PRODUCT_BRANCH)
public class ProductBranch extends BaseEntity {
    @NotNull(message = "Product id is required")
    private Long productId;

    @NotNull(message = "Branch id is required")
    private Long branchId;

    @NotBlank(message = "Status is required")
    private String status;
}
