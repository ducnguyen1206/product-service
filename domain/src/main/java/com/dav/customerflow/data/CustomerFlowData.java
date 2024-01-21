package com.dav.customerflow.data;

import com.dav.customerflow.entity.*;

import java.util.List;

public interface CustomerFlowData {
    Product save(Product product);

    boolean existsByProductName(String productName);

    Category getCategoryByCategoryName(String categoryName);

    Branch getBranchByBranchCode(int branchCode);

    Branch findBranchByBranchId(Long branchId);

    void saveProductBranch(ProductBranch productBranch);

    List<Category> getAllCategory();

    Category getCategoryByCategoryId(Long categoryId);

    List<Product> getProductByCategoryId(Long categoryId);

    List<Product> getAllProducts();

    Reservation saveReservation(Reservation reservation);
}
