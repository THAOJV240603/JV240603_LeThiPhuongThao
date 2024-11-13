package com.ra.EmpManagement.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Dept_id;
    @Column(name = "dept_name", length = 100, nullable = false, unique = true)
    private String Dept_name;
    @Column(name = "dept_description")
    private String Dept_description;
    @Column(name = "dept_status")
    private String Dept_status;

    @OneToMany(mappedBy = "deptId")
    private Set<Employee> employees;
}