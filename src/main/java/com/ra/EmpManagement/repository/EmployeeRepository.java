package com.ra.EmpManagement.repository;

import com.ra.EmpManagement.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Tìm kiếm theo tên
    @Query("select e from Employee e where e.Emp_name like %:keyword%")
    List<Employee> searchByName(String keyword);
}
