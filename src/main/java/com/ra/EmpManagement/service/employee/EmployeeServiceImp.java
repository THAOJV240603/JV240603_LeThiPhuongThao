package com.ra.EmpManagement.service.employee;

import com.ra.EmpManagement.model.dto.employee.EmployeeRequestDTO;
import com.ra.EmpManagement.model.dto.employee.EmployeeResponseDTO;
import com.ra.EmpManagement.model.dto.employee.EmployeeUpdateRequestDTO;
import com.ra.EmpManagement.model.entity.Department;
import com.ra.EmpManagement.model.entity.Employee;
import com.ra.EmpManagement.repository.DepartmentRepository;
import com.ra.EmpManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<EmployeeResponseDTO> findAll() {
        //convert entity --> DTO
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDTO> responseDTOS = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            responseDTO.setEmp_id(employee.getEmp_id());
            responseDTO.setEmp_name(employee.getEmp_name());
            responseDTO.setEmp_BirthOfDate(employee.getEmp_BirthOfDate());
            responseDTO.setEmp_sex(employee.getEmp_sex()?"Nam" : "Nữ");
            responseDTO.setEmp_address(employee.getEmp_address());
            responseDTO.setEmp_email(employee.getEmp_email());
            responseDTO.setEmp_phone(employee.getEmp_phone());
            responseDTO.setEmp_avatar(employee.getEmp_avatar());
            responseDTO.setEmp_status(employee.getEmp_status()?"Đang làm việc" : "Nghỉ việc");
            responseDTOS.add(responseDTO);
        }
        return responseDTOS;
    }

    @Override
    public EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO) {
        Department department = departmentRepository.findById(employeeRequestDTO.getDept_id()).orElse(null);
        Employee employee = Employee.builder()
                .Emp_name(employeeRequestDTO.getEmp_name())
                .Emp_BirthOfDate(employeeRequestDTO.getEmp_BirthOfDate())
                .Emp_BirthOfDate(employeeRequestDTO.getEmp_BirthOfDate())
                .Emp_sex(employeeRequestDTO.getEmp_sex())
                .Emp_address(employeeRequestDTO.getEmp_address())
                .Emp_email(employeeRequestDTO.getEmp_email())
                .Emp_phone(employeeRequestDTO.getEmp_phone())
                .Emp_avatar(employeeRequestDTO.getEmp_avatar())
                .Emp_status(employeeRequestDTO.getEmp_status())
                .Dept_id(department)
                .build();
        Employee employeeNew = employeeRepository.save(employee);

        EmployeeResponseDTO responseDTO = EmployeeResponseDTO.builder()
                .Emp_id(employeeNew.getEmp_id())
                .Emp_name(employeeNew.getEmp_name())
                .Emp_BirthOfDate(employeeNew.getEmp_BirthOfDate())
                .Emp_BirthOfDate(employeeNew.getEmp_BirthOfDate())
                .Emp_sex(employeeNew.getEmp_sex()?"Nam" : "Nữ")
                .Emp_address(employeeNew.getEmp_address())
                .Emp_email(employeeNew.getEmp_email())
                .Emp_phone(employeeNew.getEmp_phone())
                .Emp_avatar(employeeNew.getEmp_avatar())
                .Emp_status(employeeNew.getEmp_status()?"Đang làm việc" : "Nghỉ việc")
                .Dept_name(employeeNew.getDept_id().getDept_name())
                .build();
        return responseDTO;
    }

    @Override
    public EmployeeResponseDTO update(EmployeeUpdateRequestDTO employeeUpdateRequestDTO) {
        Department department = departmentRepository.findById(employeeUpdateRequestDTO.getDept_id()).orElse(null);
        Employee employee = Employee.builder()
                .Emp_id(employeeUpdateRequestDTO.getEmp_id())
                .Emp_name(employeeUpdateRequestDTO.getEmp_name())
                .Emp_BirthOfDate(employeeUpdateRequestDTO.getEmp_BirthOfDate())
                .Emp_BirthOfDate(employeeUpdateRequestDTO.getEmp_BirthOfDate())
                .Emp_sex(employeeUpdateRequestDTO.getEmp_sex())
                .Emp_address(employeeUpdateRequestDTO.getEmp_address())
                .Emp_email(employeeUpdateRequestDTO.getEmp_email())
                .Emp_phone(employeeUpdateRequestDTO.getEmp_phone())
                .Emp_avatar(employeeUpdateRequestDTO.getEmp_avatar())
                .Emp_status(employeeUpdateRequestDTO.getEmp_status())
                .Dept_id(department)
                .build();
        Employee employeeNew = employeeRepository.save(employee);

        EmployeeResponseDTO responseDTO = EmployeeResponseDTO.builder()
                .Emp_id(employeeNew.getEmp_id())
                .Emp_name(employeeNew.getEmp_name())
                .Emp_BirthOfDate(employeeNew.getEmp_BirthOfDate())
                .Emp_BirthOfDate(employeeNew.getEmp_BirthOfDate())
                .Emp_sex(employeeNew.getEmp_sex()?"Nam" : "Nữ")
                .Emp_address(employeeNew.getEmp_address())
                .Emp_email(employeeNew.getEmp_email())
                .Emp_phone(employeeNew.getEmp_phone())
                .Emp_avatar(employeeNew.getEmp_avatar())
                .Emp_status(employeeNew.getEmp_status()?"Đang làm việc" : "Nghỉ việc")
                .Dept_name(employeeNew.getDept_id().getDept_name())
                .build();
        return responseDTO;
    }

    @Override
    public void delete(Long Emp_id) {
        employeeRepository.deleteById(Emp_id);
    }

    @Override
    public List<EmployeeResponseDTO> searchByName(String keyword) {
        List<Employee> employees = employeeRepository.searchByName(keyword);
        //Java 8
        List<EmployeeResponseDTO> responseDTOS = employees.stream().map(employee -> {
            EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
            responseDTO.setEmp_id(employee.getEmp_id());
            responseDTO.setEmp_name(employee.getEmp_name());
            responseDTO.setEmp_BirthOfDate(employee.getEmp_BirthOfDate());
            responseDTO.setEmp_sex(employee.getEmp_sex()?"Nam" : "Nữ");
            responseDTO.setEmp_address(employee.getEmp_address());
            responseDTO.setEmp_email(employee.getEmp_email());
            responseDTO.setEmp_phone(employee.getEmp_phone());
            responseDTO.setEmp_avatar(employee.getEmp_avatar());
            responseDTO.setEmp_status(employee.getEmp_status()?"Đang làm việc" : "Nghỉ việc");
            responseDTO.setDept_name(employee.getDept_id().getDept_name());
            return responseDTO;
        }).toList();
        return responseDTOS;
    }
}
