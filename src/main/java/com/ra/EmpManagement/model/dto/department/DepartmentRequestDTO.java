package com.ra.EmpManagement.model.dto.department;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentRequestDTO {
    private String Dept_name;
    private String Dept_description;
    private Boolean Dept_status;
}
