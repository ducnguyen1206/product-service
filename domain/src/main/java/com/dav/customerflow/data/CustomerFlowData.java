package com.dav.customerflow.data;

import com.dav.customerflow.entity.Branch;
import com.dav.customerflow.entity.Category;
import com.dav.customerflow.entity.Product;
import com.dav.customerflow.entity.ProductBranch;

import java.util.List;

public interface CustomerFlowData {
    Product save(Product product);

    boolean existsByProductName(String productName);

    Category getCategoryByCategoryName(String categoryName);

    Branch getBranchByBranchCode(int branchCode);

    void saveProductBranch(ProductBranch productBranch);

    List<Category> getAllCategory();

    Category getCategoryByCategoryId(Long categoryId);

    List<Product> getProductByCategoryId(Long categoryId);

    List<Product> getAllProducts();
}
