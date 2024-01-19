package com.dav.customerflow.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.dav.customerflow.constant.DatabaseConstant.TBL_PRODUCT_BRANCH;

@Entity
@Getter
@Setter
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
