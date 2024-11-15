package com.ra.EmpManagement.model.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeResponseDTO {
    private Long Emp_id;
    private String Emp_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate Emp_BirthOfDate;
    private String Emp_sex;
    private String Emp_address;
    private String Emp_email;
    private String Emp_phone;
    private String Emp_avatar;
    private String Emp_status;
    private String Dept_name;
}
