package com.dav.customerflow.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private Long id;

    @NotBlank(message = "Category Name is required")
    private String categoryName;
}
