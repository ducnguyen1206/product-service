package com.dav.customerflow.repository;

import com.dav.customerflow.entity.Branch;
import com.dav.customerflow.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
