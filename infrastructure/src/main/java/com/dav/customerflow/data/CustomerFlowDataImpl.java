package com.dav.customerflow.data;

import com.dav.customerflow.entity.*;
import com.dav.customerflow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerFlowDataImpl implements CustomerFlowData {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ProductBranchRepository productBranchRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean existsByProductName(String productName) {
        return productRepository.existsByProductName(productName);
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        Optional<Category> category = categoryRepository.findByCategoryName(categoryName);
        return category.orElse(null);
    }

    @Override
    public Branch getBranchByBranchCode(int branchCode) {
        return branchRepository.findByBranchCode(branchCode).orElse(null);
    }

    @Override
    public Branch findBranchByBranchId(Long branchId) {
        return branchRepository.findById(branchId).orElse(null);
    }

    @Override
    public void saveProductBranch(ProductBranch productBranch) {
        productBranchRepository.save(productBranch);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByCategoryId(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.orElse(null);
    }

    @Override
    public List<Product> getProductByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
