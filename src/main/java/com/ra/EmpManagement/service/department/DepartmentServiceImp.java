package com.ra.EmpManagement.service.department;

import com.ra.EmpManagement.model.dto.department.DepartmentRequestDTO;
import com.ra.EmpManagement.model.dto.department.DepartmentResponseDTO;
import com.ra.EmpManagement.model.dto.department.DepartmentUpdateRequestDTO;
import com.ra.EmpManagement.model.entity.Department;
import com.ra.EmpManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentResponseDTO> findAll() {
        //convert entity --> DTO
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentResponseDTO> responseDTOS = new ArrayList<>();
        for (Department department : departments) {
            DepartmentResponseDTO responseDTO  = new DepartmentResponseDTO();
            responseDTO.setDept_id(department.getDept_id());
            responseDTO.setDept_name(department.getDept_name());
            responseDTO.setDept_description(department.getDept_description());
            responseDTO.setDept_status(department.getDept_status()?"Hoạt động":"Không hoạt động") ;
            responseDTOS.add(responseDTO);
        }
        return responseDTOS;
    }

    @Override
    public DepartmentResponseDTO create(DepartmentRequestDTO departmentRequestDTO) {
        Department department = Department.builder()
                .Dept_name(departmentRequestDTO.getDept_name())
                .Dept_description(departmentRequestDTO.getDept_description())
                .Dept_status(departmentRequestDTO.getDept_status())
                .build();
        Department departmentNew = departmentRepository.save(department);

        DepartmentResponseDTO responseDTO = DepartmentResponseDTO.builder()
                .Dept_id(departmentNew.getDept_id())
                .Dept_name(departmentNew.getDept_name())
                .Dept_description(departmentNew.getDept_description())
                .Dept_status(departmentNew.getDept_status()?"Hoạt động":"Không hoạt động")
                .build();
        return responseDTO;
    }

    @Override
    public DepartmentResponseDTO update(DepartmentUpdateRequestDTO departmentUpdateRequestDTO) {
        //convert entity --> DTO
        Department department = Department.builder()
                .Dept_id(departmentUpdateRequestDTO.getDept_id())
                .Dept_name(departmentUpdateRequestDTO.getDept_name())
                .Dept_description(departmentUpdateRequestDTO.getDept_description())
                .Dept_status(departmentUpdateRequestDTO.getDept_status())
                .build();
        Department departmentNew = departmentRepository.save(department);

        DepartmentResponseDTO responseDTO = DepartmentResponseDTO.builder()
                .Dept_id(departmentNew.getDept_id())
                .Dept_name(departmentNew.getDept_name())
                .Dept_description(departmentNew.getDept_description())
                .Dept_status(departmentNew.getDept_status()?"Hoạt động":"Không hoạt động")
                .build();
        return responseDTO;
    }

    @Override
    public void delete(Long Dept_id) {
        departmentRepository.deleteById(Dept_id);
    }
}
