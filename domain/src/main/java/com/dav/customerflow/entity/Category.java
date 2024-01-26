package com.dav.customerflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.dav.customerflow.constant.DatabaseConstant.TBL_CATEGORY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TBL_CATEGORY)
public class Category extends BaseEntity {
    @NotBlank(message = "Category Name is required")
    private String categoryName;
}
