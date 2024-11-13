package com.ra.EmpManagement.repository;

import com.ra.EmpManagement.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
