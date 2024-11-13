package com.ra.EmpManagement.repository;

import com.ra.EmpManagement.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
