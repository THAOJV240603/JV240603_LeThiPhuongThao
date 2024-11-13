package com.ra.EmpManagement.service.employee;

import com.ra.EmpManagement.model.dto.employee.EmployeeRequestDTO;
import com.ra.EmpManagement.model.dto.employee.EmployeeResponseDTO;
import com.ra.EmpManagement.model.dto.employee.EmployeeUpdateRequestDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> findAll();
    EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO update(EmployeeUpdateRequestDTO employeeUpdateRequestDTO);
    void delete(Long Emp_id);
    //Tìm kiếm theo tên
    List<EmployeeResponseDTO> searchByName(String keyword);
}
