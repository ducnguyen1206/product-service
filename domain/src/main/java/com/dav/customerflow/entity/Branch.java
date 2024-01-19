package com.dav.customerflow.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.dav.customerflow.constant.DatabaseConstant.TBL_BRANCH;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TBL_BRANCH)
public class Branch extends BaseEntity {
    @NotBlank(message = "Branch name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "Branch code is required")
    private Integer branchCode;
}
