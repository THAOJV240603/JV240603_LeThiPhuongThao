package com.ra.EmpManagement.model.dto.department;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentResponseDTO {
    private Long Dept_id;
    private String Dept_name;
    private String Dept_description;
    private String Dept_status;
}
