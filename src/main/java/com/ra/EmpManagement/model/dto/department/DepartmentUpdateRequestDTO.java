package com.ra.EmpManagement.model.dto.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentUpdateRequestDTO {
    private Long Dept_id;
    private String Dept_name;
    private String Dept_description;
    private Boolean Dept_status;
}
