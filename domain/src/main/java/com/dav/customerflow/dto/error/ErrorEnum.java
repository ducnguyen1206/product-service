package com.dav.customerflow.dto.error;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    CATEGORY_NOT_FOUND("EC-001", "Category not found"),
    BRANCH_NOT_FOUND("EC-002", "Branch not found"),
    PRODUCT_NAME_EXISTED("EC-003", "Product name existed");

    private final String code;
    private final String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
