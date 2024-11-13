package com.ra.EmpManagement.controller;

import com.ra.EmpManagement.model.dto.employee.EmployeeRequestDTO;
import com.ra.EmpManagement.model.dto.employee.EmployeeResponseDTO;
import com.ra.EmpManagement.model.dto.employee.EmployeeUpdateRequestDTO;
import com.ra.EmpManagement.service.employee.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        List<EmployeeResponseDTO> responseDTOS = employeeService.findAll();
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        EmployeeResponseDTO responseDTO = employeeService.create(employeeRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody EmployeeUpdateRequestDTO employeeUpdateRequestDTO) {
        employeeUpdateRequestDTO.setEmp_id(id);
        EmployeeResponseDTO responseDTO  = employeeService.update(employeeUpdateRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Tìm kiếm theo tên
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "keyword") String keyword) {
        List<EmployeeResponseDTO> responseDTOS = employeeService.searchByName(keyword);
        if (responseDTOS != null) {
            return new ResponseEntity<>("Không tìm thấy thông tin nhân viên", HttpStatus.OK);
        }
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }
}