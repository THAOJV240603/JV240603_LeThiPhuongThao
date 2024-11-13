package com.ra.EmpManagement.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Emp_id;
    @Column(name = "emp_name", length = 100, nullable = false)
    private String Emp_name;
    @Column(name = "emp_BirthOfDate", nullable = false)
    private LocalDate Emp_BirthOfDate;
    @Column(name = "emp_sex", nullable = false)
    private Boolean Emp_sex;
    @Column(name = "emp_address", nullable = false)
    private String Emp_address;
    @Column(name = "emp_email", length = 200, nullable = false, unique = true)
    private String Emp_email;
    @Column(name = "emp_phone", length = 11, nullable = false, unique = true)
    private String Emp_phone;
    @Column(name = "emp_avatar")
    private String Emp_avatar;
    @Column(name = "emp_status")
    private Boolean Emp_status;

    @ManyToOne
    @JoinColumn(name = "deptId", referencedColumnName = "Dept_id")
    private Department Dept_id;
}
