package com.dav.customerflow.data;

import com.dav.customerflow.entity.Branch;
import com.dav.customerflow.entity.Category;
import com.dav.customerflow.entity.Product;
import com.dav.customerflow.entity.ProductBranch;

public interface CustomerFlowData {
    Product save(Product product);

    boolean existsByProductName(String productName);

    Category getCategoryByCategoryName(String categoryName);

    Branch getBranchByBranchCode(int branchCode);

    void saveProductBranch(ProductBranch productBranch);
}
