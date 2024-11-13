package com.ra.EmpManagement.controller;

import com.ra.EmpManagement.model.dto.department.DepartmentResponseDTO;
import com.ra.EmpManagement.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
