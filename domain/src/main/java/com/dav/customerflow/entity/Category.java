package com.dav.customerflow.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
