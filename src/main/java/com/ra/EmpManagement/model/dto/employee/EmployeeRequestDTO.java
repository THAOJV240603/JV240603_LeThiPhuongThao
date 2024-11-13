package com.ra.EmpManagement.model.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ra.EmpManagement.model.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeRequestDTO {
    private String Emp_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate Emp_BirthOfDate;
    private Boolean Emp_sex;
    private String Emp_address;
    private String Emp_email;
    private String Emp_phone;
    private String Emp_avatar;
    private Boolean Emp_status;
    private Department Dept_id;
}
