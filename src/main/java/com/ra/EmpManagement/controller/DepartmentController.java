package com.ra.EmpManagement.controller;

import com.ra.EmpManagement.model.dto.department.DepartmentRequestDTO;
import com.ra.EmpManagement.model.dto.department.DepartmentResponseDTO;
import com.ra.EmpManagement.model.dto.department.DepartmentUpdateRequestDTO;
import com.ra.EmpManagement.service.department.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        List<DepartmentResponseDTO> responseDTOS = departmentService.findAll();
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        DepartmentResponseDTO responseDTO = departmentService.create(departmentRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody DepartmentUpdateRequestDTO departmentUpdateRequestDTO) {
        departmentUpdateRequestDTO.setDept_id(id);
        DepartmentResponseDTO responseDTO  = departmentService.update(departmentUpdateRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
