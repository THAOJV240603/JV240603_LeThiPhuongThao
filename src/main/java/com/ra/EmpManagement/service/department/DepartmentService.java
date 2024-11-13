package com.ra.EmpManagement.service.department;

import com.ra.EmpManagement.model.dto.department.DepartmentRequestDTO;
import com.ra.EmpManagement.model.dto.department.DepartmentResponseDTO;
import com.ra.EmpManagement.model.dto.department.DepartmentUpdateRequestDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponseDTO> findAll();
    DepartmentResponseDTO create(DepartmentRequestDTO departmentRequestDTO);
    DepartmentResponseDTO update(DepartmentUpdateRequestDTO departmentUpdateRequestDTO);
    void delete(Integer Dept_id);
}
